package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class Mainmain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Integer Lid = (Integer)session.getAttribute("id");
//
//		if(Lid == null) {
//			ServletContext context = getServletContext();
//			RequestDispatcher dispatcher = context.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//			dispatcher.forward(request, response);
//			return;
//		}
//
//		int user_id = (int)Lid;
//		DeckDAO Ddao = new DeckDAO();
//		List<Deck> decks = Ddao.getDecks(user_id);
//		request.setAttribute("decks", decks);
//
//		ServletContext context = getServletContext();
//		RequestDispatcher dispatcher = context.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
//		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
