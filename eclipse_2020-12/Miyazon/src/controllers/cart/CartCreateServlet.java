package controllers.cart;

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

import models.Cart;
import models.Listing;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CartNewServlet
 */
@MultipartConfig
@WebServlet("/cart/create")
public class CartCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _token = (String) request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			Cart c = new Cart();
			User login_user = (User) request.getSession().getAttribute("login_user");
			Listing listing = (Listing) request.getSession().getAttribute("listing");
			c.setUser(login_user);
			c.setListing(listing);
			c.setNumber(Integer.parseInt(request.getParameter("number")));

			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			c.setCreated_at(currentTime);
			c.setUpdated_at(currentTime);

			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();

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
			request.getSession().setAttribute("_token", _token);
			request.getSession().setAttribute("my_cart", my_cart);
			request.setAttribute("cart_count", cart_count);
			request.setAttribute("page", page);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp");
			rd.forward(request, response);
		}
	}
}