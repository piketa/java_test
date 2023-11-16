package controllers.toppage;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Listing;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class Toppage
 */
@WebServlet("/toppage")
public class Toppage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Toppage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();
		User login_user = (User) request.getSession().getAttribute("login_user");
		if (login_user == null) {
			response.sendRedirect("/Miyazon/login");
		} else {
			System.out.println(login_user.getName());
			int page;
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {
				page = 1;
			}
			List<Listing> listing = em.createNamedQuery("getAllListing", Listing.class).setFirstResult(15 * (page - 1)).setMaxResults(15).getResultList();
			long listing_count = (long) em.createNamedQuery("getMyListingCount", Long.class)
					.setParameter("user", login_user).getSingleResult();
			em.close();
			request.setAttribute("listing", listing);
			request.setAttribute("listing_count", listing_count);
			request.setAttribute("page", page);
			if (request.getSession().getAttribute("flush") != null) {
				request.setAttribute("flush", request.getSession().getAttribute("flush"));
				request.getSession().removeAttribute("flush");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
			rd.forward(request, response);
		}
	}
}