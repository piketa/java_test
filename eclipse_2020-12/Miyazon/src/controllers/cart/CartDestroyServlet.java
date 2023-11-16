package controllers.cart;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cart;
import utils.DBUtil;

/**
 * Servlet implementation class CartDestroyServlet
 */
@WebServlet("/cart/destroy")
public class CartDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();

		// セッションスコープからカートのIDを取得して該当のIDのカート1件のみをデータベースから取得
		Cart c = em.find(Cart.class, Integer.parseInt(request.getParameter("cart_id")));
		em.getTransaction().begin();
		em.remove(c); // カートの中身削除
		em.getTransaction().commit();
		em.close();
		request.getSession().setAttribute("flush", "カートを削除しました。");

		// トップページへ遷移
		response.sendRedirect(request.getContextPath() + "/toppage");
	}
}