package controllers.purchase;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Purchase;
import models.User;
import utils.DBUtil;



/**
 * Servlet implementation class PurchaseIndexServlet
 */
@WebServlet("/purchase/index")
public class PurchaseIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 EntityManager em = DBUtil.createEntityManager();
         User login_user = (User) request.getSession().getAttribute("login_user");
         List<Purchase> myPurchaseList = em.createNamedQuery("getMyAllPurchases", Purchase.class).setParameter("user", login_user).getResultList();
         em.close();

         request.setAttribute("myPurchaseList", myPurchaseList);

         // 画面遷移
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchase/index.jsp");
         rd.forward(request, response);

	}

}
