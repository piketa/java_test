package controllers.listing;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.Listing;
import models.User;
import utils.DBUtil;
import utils.EncryptUtil;
import validators.ListingValidator;

/**
 * Servlet implementation class ListingCreateServlert
 */
@MultipartConfig
@WebServlet("/listing/create")
public class ListingCreateServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListingCreateServlert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _token = (String) request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			// 画像アップロード
			Part part = request.getPart("image");
			String filename = getFileName(part);
			String filePath = getServletContext().getRealPath("/uploads/") + filename;

			System.out.println("filePath!!!" + filePath);

			File uploadDir = new File(getServletContext().getRealPath("/uploads/"));
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			part.write(filePath);
			EntityManager em = DBUtil.createEntityManager();

			Listing l = new Listing();
			User login_user = (User) request.getSession().getAttribute("login_user");
			l.setUser(login_user);
			l.setProduct_name(request.getParameter("product_name"));
			l.setCategory(request.getParameter("category"));
			l.setPrice(Integer.parseInt(request.getParameter("price")));
			l.setStock(Integer.parseInt(request.getParameter("stock")));
			l.setImage(request.getParameter("image"));
			l.setIntroduction(request.getParameter("introduction"));

			l.setImage(filename);

			List<String> errors = ListingValidator.validate(l);
			if (errors.size() > 0) {
				em.close();
				request.setAttribute("_token", request.getSession().getId());
				request.setAttribute("listing", l);
				request.setAttribute("errors", errors);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listing/new.jsp");
				rd.forward(request, response);
			} else {
				em.getTransaction().begin();
				em.persist(l);
				em.getTransaction().commit();
				int page;
				try {
					page = Integer.parseInt(request.getParameter("page"));
				} catch (Exception e) {
					page = 1;
				}
				List<Listing> listing = em.createNamedQuery("getAllListing", Listing.class)
						.setFirstResult(15 * (page - 1)).setMaxResults(15).getResultList();
				long listing_count = (long) em.createNamedQuery("getMyListingCount", Long.class)
						.setParameter("user", login_user).getSingleResult();
				em.close();
				request.setAttribute("listing", listing);
				request.setAttribute("listing_count", listing_count);
				request.setAttribute("page", page);
				request.getSession().setAttribute("flush", "登録が完了しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
				rd.forward(request, response);
			}
		}

	}

	// 拡張子を変えずに、ランダムな名前のファイルを生成する
	private String getFileName(Part part) {
		String[] headerArrays = part.getHeader("Content-Disposition").split(";");
		String fileName = null;
		for (String head : headerArrays) {
			if (head.trim().startsWith("filename")) {
				fileName = head.substring(head.indexOf('"') + 1).replaceAll("\"", "");
			}
		}

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		String temp = EncryptUtil.getPasswordEncrypt(currentTime.toString(),
				(String) this.getServletContext().getAttribute("pepper"));

		String extension = fileName.substring(fileName.lastIndexOf("."));

		String rndFileName = temp + extension;

		return rndFileName;
	}
}