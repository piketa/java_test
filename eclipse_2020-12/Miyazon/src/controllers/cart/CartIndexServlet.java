package controllers.cart;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cart;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CartIndexServlet
 */
@WebServlet("/cart/index")
public class CartIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartIndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();

		User login_user = (User) request.getSession().getAttribute("login_user");

		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}

		List<Cart> my_cart = em.createNamedQuery("getMyAllCart", Cart.class).setParameter("user", login_user)
				.setFirstResult(15 * (page - 1)).setMaxResults(15).getResultList();
		long cart_count = (long) em.createNamedQuery("getMyCartCount", Long.class).setParameter("user", login_user)
				.getSingleResult();
		em.close();
		request.getSession().setAttribute("my_cart", my_cart);
		request.setAttribute("cart_count", cart_count);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp");
		rd.forward(request, response);
	}
}
