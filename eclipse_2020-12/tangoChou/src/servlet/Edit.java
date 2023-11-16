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

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer Lid = (Integer)session.getAttribute("id");

		if(Lid == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		String id = request.getParameter("id");
		request.setAttribute("card_id", id);

		int card_id = Integer.parseInt(id);
		CardDAO dao = new CardDAO();
		Card card = dao.getCard(card_id);
		request.setAttribute("card", card);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
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
		String id = request.getParameter("card_id");
		int card_id = Integer.parseInt(id);
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		if(question == null || question.equals("") && answer == null || answer.equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
			dispatcher.forward(request, response);
			return;
		}

		CardDAO dao = new CardDAO();
		dao.edit(card_id, question, answer);

		Card card = dao.getCard(card_id);
		int deckId = card.getDeck_id();

		List<Card> cards = dao.getCards(deckId);
		request.setAttribute("cards", cards);

		Integer i = Integer.valueOf(deckId);
		String deck_id = i.toString();
		request.setAttribute("deck_id", deck_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deck.jsp");
		dispatcher.forward(request, response);
	}

}
