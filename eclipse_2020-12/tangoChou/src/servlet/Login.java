package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("logout");
		if(action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else if(action.equals("logout")){
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("/tangoChou/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		User user = new User(email, pass);
		UserDAO dao = new UserDAO();
		Integer id = dao.login(user);

		if(id == 0) {
			boolean isEmail = dao.checkEmail(email);
			if(!(isEmail)) {
				request.setAttribute("errorMsg", "入力されたユーザーネームはアカウントと一致しません。<br>ユーザーネームをご確認の上、もう一度実行してください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
				return;
			}
			request.setAttribute("errorMsg", "パスワードが間違っています。パスワードをご確認ください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);

			response.sendRedirect("/tangoChou/");
		}
	}
}
