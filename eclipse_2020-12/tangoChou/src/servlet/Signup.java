package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeckDAO;
import dao.UserDAO;
import model.Deck;
import model.User;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String verify = request.getParameter("verify");

		if( !(pass.matches("^[\\w-@+*;:#$%&]{7,}$")) ) {
			request.setAttribute("errorMsg", "パスワードは半角英数字、半角記号で入力してください。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if(!(pass.equals(verify))) {
			request.setAttribute("errorMsg", "パスワードが一致していません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		User user = new User(email, pass);
		UserDAO Udao = new UserDAO();
		boolean signupRs = Udao.signup(user);

		if( !(signupRs) ) {
			request.setAttribute("errorMsg", "入力されたメールアドレスは既に登録されています。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Integer id = Udao.login(user);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);

		int user_id = (int)id;
		Deck defaultDeck = new Deck(0, user_id);
		DeckDAO Ddao = new DeckDAO();
		Ddao.createDeck(defaultDeck);

		response.sendRedirect("/tangoChou/");
	}
}
