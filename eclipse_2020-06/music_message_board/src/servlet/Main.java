package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Message;
import model.PostMessageLogic;
import model.UserInformation;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        List<Message> messageList = (List<Message>) application.getAttribute("messageList");

        if(messageList == null){
            messageList = new ArrayList<>();
            application.setAttribute("messageList",messageList);
        }

        HttpSession session = request.getSession();
        UserInformation loginUser = (UserInformation) session.getAttribute("loginUser");

        if(loginUser == null){
            response.sendRedirect("./login.jsp");
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
            dispatcher.forward(request, response);
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        if(text != null && text.length() != 0){
            ServletContext application = this.getServletContext();
            List<Message> messageList = (List<Message>) application.getAttribute("messageList");

            HttpSession session = request.getSession();
            UserInformation loginUser = (UserInformation) session.getAttribute("loginUser");

            Message message = new Message(loginUser.getName(),text);
            PostMessageLogic postMessageLogic = new PostMessageLogic();
            postMessageLogic.execute(message, messageList);

            application.setAttribute("messageList", messageList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
        dispatcher.forward(request, response);
    }
}

