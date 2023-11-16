package controllers.purchase;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cart;
import models.Purchase;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CartConfirmServlet
 */
@WebServlet("/purchase/confirm")
public class PurchaseConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseConfirmServlet() {
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
		EntityManager em = DBUtil.createEntityManager();
		User login_user = (User) request.getSession().getAttribute("login_user");
		Cart c = em.find(Cart.class, Integer.parseInt(request.getParameter("cart_id")));
		em.close();

		Purchase p = new Purchase();
		p.setUser(login_user);
		p.setListing(c.getListing());
		p.setNumber(Integer.parseInt(request.getParameter("number")));
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		p.setCreated_at(currentTime);
		p.setPay_method("pay_method");

		request.getSession().setAttribute("purchase", p);
		request.getSession().setAttribute("cart_id", c.getId());
		request.setAttribute("purchase", p);
		// 画面遷移
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchase/confirm.jsp");
		rd.forward(request, response);
	}

}
