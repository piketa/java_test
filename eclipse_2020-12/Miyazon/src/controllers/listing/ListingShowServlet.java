package controllers.listing;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Listing;
import utils.DBUtil;

/**
 * Servlet implementation class ListingShowServlet
 */
@WebServlet("/listing/show")
public class ListingShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListingShowServlet() {
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
		Listing l = em.find(Listing.class, Integer.parseInt(request.getParameter("id")));
		em.close();
		request.getSession().setAttribute("listing", l);
		request.setAttribute("_token", request.getSession().getId());
		if (request.getSession().getAttribute("flush") != null) {
			request.getSession().removeAttribute("flush");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listing/show.jsp");
		rd.forward(request, response);
	}
}
