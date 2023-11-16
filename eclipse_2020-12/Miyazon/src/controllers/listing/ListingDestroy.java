package controllers.listing;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Listing;
import utils.DBUtil;

/**
 * Servlet implementation class ListingDestroy
 */
@WebServlet("/listing/destroy")
public class ListingDestroy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListingDestroy() {
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
		// セッションスコープから商品のIDを取得して該当のIDの商品1件のみをデータベースから取得
		EntityManager em = DBUtil.createEntityManager();
		Listing l = em.find(Listing.class,Integer.parseInt(request.getParameter("listing_id")));
		em.getTransaction().begin();
		em.remove(l); // カートの中身削除
		em.getTransaction().commit();
		em.close();
		request.getSession().setAttribute("flush", "登録している商品を削除しました。");

		// トップページへ画面遷移
		response.sendRedirect(request.getContextPath() + "/toppage");
	}
}
