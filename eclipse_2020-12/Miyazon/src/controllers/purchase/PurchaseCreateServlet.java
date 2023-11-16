package controllers.purchase;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cart;
import models.Listing;
import models.Purchase;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class PurchaseCreateServlet
 */
@WebServlet("/purchase/create")
public class PurchaseCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("購入処理開始");
		EntityManager em = DBUtil.createEntityManager();
		User login_user = (User) request.getSession().getAttribute("login_user");
		Purchase p = (Purchase) request.getSession().getAttribute("purchase");

		p.setCreated_at(new Timestamp(System.currentTimeMillis()));
		p.setPay_method(request.getParameter("pay_method"));

		Integer cart_id = (Integer) request.getSession().getAttribute("cart_id");
		Cart c = em.find(Cart.class, cart_id);

		// Lisitingモデルを使って在庫減らす
		Integer listing_id = p.getListing().getId();
		Listing l = em.find(Listing.class, listing_id);
		Integer stock = l.getStock();
		stock -= p.getNumber();
		l.setStock(stock);

		em.getTransaction().begin();
		em.persist(p);
		em.remove(c);
		em.getTransaction().commit();
		request.getSession().setAttribute("listing", null);

		List<Purchase> myPurchaseList = em.createNamedQuery("getMyAllPurchases", Purchase.class)
				.setParameter("user", login_user).getResultList();
		request.setAttribute("myPurchaseList", myPurchaseList);
		em.close();

		// 画面遷移
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchase/index.jsp");
		rd.forward(request, response);
	}

}