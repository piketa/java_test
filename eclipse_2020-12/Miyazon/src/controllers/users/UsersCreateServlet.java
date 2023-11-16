package controllers.users;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class UsersCreateServlet
 */
@WebServlet("/Users/create")
public class UsersCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _token = (String) request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			System.out.println("_token=" + _token);
			String account = request.getParameter("account");
			System.out.println(account);
			String name = request.getParameter("name");
			System.out.println(name);
			String password = request.getParameter("password");
			System.out.println(password);
			String address = request.getParameter("address");
			System.out.println(address);
			String tel = request.getParameter("tel");
			System.out.println(tel);
			String birthday = request.getParameter("birthday");
			System.out.println(birthday);
			String sex = request.getParameter("sex");
			System.out.println(sex);
			String credit_card_company = request.getParameter("credit_card_company");
			System.out.println(credit_card_company);
			String credit_card_number = request.getParameter("credit_card_number");
			System.out.println(credit_card_number);
			String bank_name = request.getParameter("bank_name");
			System.out.println(bank_name);
			String branch_name = request.getParameter("branch_name");
			System.out.println(branch_name);
			String account_type = request.getParameter("account_type");
			System.out.println(account_type);
			String account_number = request.getParameter("account_number");
			System.out.println(account_number);
			Integer admin_flag = (Integer.parseInt(request.getParameter("admin_flag")));
			System.out.println(admin_flag);

			String password2 = EncryptUtil.getPasswordEncrypt(password,
					(String) this.getServletContext().getAttribute("pepper"));
			System.out.println(password2);
			User u = new User();
			u.setAccount(account);
			u.setName(name);
			u.setPassword(password2);
			u.setAddress(address);
			u.setTel(tel);
			u.setBirthday(birthday);
			u.setSex(sex);
			u.setCredit_card_company(credit_card_company);
			u.setCredit_card_number(credit_card_number);
			u.setBank_name(bank_name);
			u.setBranch_name(branch_name);
			u.setAccount_type(account_type);
			u.setAccount_number(account_number);
			u.setAdmin_flag(admin_flag);

			EntityManager em = DBUtil.createEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			request.getSession().setAttribute("flush", "登録が完了しました。");
			response.sendRedirect("/Miyazon/toppage");
		}
	}
}
