package controllers.users;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class UsersDestroyServlet
 */
@WebServlet("/users/destroy")
public class UsersDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersDestroyServlet() {
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
			// セッションスコープからユーザーのIDを取得して該当のIDのユーザー1件のみをデータベースから取得
			User u = em.find(User.class, (Integer) (request.getSession().getAttribute("user_id")));
			em.getTransaction().begin();
			em.remove(u); // データ削除
			em.getTransaction().commit();
			em.close();
			request.getSession().setAttribute("flush", "退会手続きが完了しました。またのご利用をお待ちしております。");
			// セッションスコープ上の不要になったデータを削除
			request.getSession().removeAttribute("user_id");
			// ログインページへリダイレクト
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
			rd.forward(request, response);
		}

	}
}
