package com.phoeducation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Count
 */
@WebServlet("/countup")
public class Count extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer number;
		String btn = request.getParameter("button");
		HttpSession session = request.getSession(true);

		if (btn == null || btn.equals("reset")) {
			number = 0;
		} else {
			number = (Integer) session.getAttribute("number");

			if (number == null) {
				number = 0;
			} else {
				number++;
			}
		}
		session.setAttribute("number", number);

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/countUp.jsp");
		dispatcher.forward(request, response);
	}

}
