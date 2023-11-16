package controllers.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

/**
 * Servlet implementation class UsersEditServlet
 */
@WebServlet("/Users/edit")
public class UsersEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		User login_user = (User) request.getSession().getAttribute("login_user");
		// ログインしていない時
		if (login_user == null) {
			response.sendRedirect("/Miyazon/login");
		} else { // ログインしている時
			request.setAttribute("_token", request.getSession().getId());
			request.setAttribute("user", login_user);
			request.getSession().setAttribute("user_id", login_user.getID());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp");
			rd.forward(request, response);
		}
	}
}