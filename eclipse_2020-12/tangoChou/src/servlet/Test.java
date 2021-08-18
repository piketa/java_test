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

@WebServlet("/Test")
public class Test extends HttpServlet {
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
		int deck_id = Integer.parseInt(id);

		CardDAO dao = new CardDAO();
		List<Card> cards = dao.getCards(deck_id);
		request.setAttribute("cards", cards);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
