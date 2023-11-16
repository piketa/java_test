package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CardDAO;
import model.Card;

@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer Lid = (Integer)session.getAttribute("id");

		if(Lid == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		String id = request.getParameter("deck_id");
		request.setAttribute("deck_id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createCard.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer Lid = (Integer)session.getAttribute("id");

		if(Lid == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("deck_id");
		request.setAttribute("deck_id", id);
		int deck_id = Integer.parseInt(id);
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		if(question == null || question.equals("")) {
			request.setAttribute("errorMsg", "問題を入力してください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createCard.jsp");
			dispatcher.forward(request, response);
			return;
		}else if(answer == null || answer.equals("")) {
			request.setAttribute("errorMsg", "答えを入力してください");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createCard.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Integer value = (Integer)session.getAttribute("id");
		int user_id = Integer.valueOf(value);

		CardDAO dao = new CardDAO();
		Card card = new Card(user_id, deck_id, question, answer);
		dao.createCard(card);

		List<Card> cards = dao.getCards(deck_id);
		request.setAttribute("cards", cards);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deck.jsp");
		dispatcher.forward(request, response);
	}
}
