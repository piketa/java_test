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
 * Servlet implementation class UsersUpdateServlet
 */
@WebServlet("/users/update")
public class UsersUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = null;
		String _token = (String) request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			Integer UserID = (Integer) request.getSession().getAttribute("user_id");

			System.out.println("UserID:" + UserID);

			u = em.find(User.class, UserID);

			String account = request.getParameter("account");
			u.setAccount(account);
			System.out.println(account);
			String name = request.getParameter("name");
			u.setName(name);
			System.out.println(name);
			String pass = request.getParameter("password");
			System.out.println(pass);

			// 暗号化
			String password = EncryptUtil.getPasswordEncrypt(pass,
					(String) this.getServletContext().getAttribute("pepper"));

			u.setPassword(password);

			String address = request.getParameter("address");
			u.setAddress(address);
			System.out.println(address);
			String tel = request.getParameter("tel");
			u.setTel(tel);
			System.out.println(tel);
			String birthday = request.getParameter("birthday");
			u.setBirthday(birthday);
			System.out.println(birthday);
			String sex = request.getParameter("sex");
			u.setSex(sex);
			System.out.println(sex);
			String credit_card_company = request.getParameter("credit_card_company");
			u.setCredit_card_company(credit_card_company);
			System.out.println(credit_card_company);
			String credit_card_number = request.getParameter("credit_card_number");
			u.setCredit_card_number(credit_card_number);
			System.out.println(credit_card_number);
			String bank_name = request.getParameter("bank_name");
			u.setBank_name(bank_name);
			System.out.println(bank_name);
			String branch_name = request.getParameter("branch_name");
			u.setBranch_name(branch_name);
			System.out.println(branch_name);
			String account_type = request.getParameter("account_type");
			u.setAccount_type(account_type);
			System.out.println(account_type);
			String account_number = request.getParameter("account_number");
			u.setAccount_number(account_number);
			System.out.println(account_number);
			Integer admin_flag = (Integer.parseInt(request.getParameter("admin_flag")));
			u.setAdmin_flag(admin_flag);
			System.out.println(admin_flag);

			// データベースを更新
			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
			request.getSession().setAttribute("flush", "登録情報の更新が完了しました。");

			// セッションスコープ上の不要になったデータを削除
			request.getSession().removeAttribute("user_id");
			// トップページへ画面遷移
			response.sendRedirect(request.getContextPath() + "/toppage");

		} else {
			// フォームに初期値を設定、さらにエラーメッセージを送る
			request.setAttribute("_token", request.getSession().getId());
			request.setAttribute("login_user", u);
			request.getSession().setAttribute("#flush_error", "内容にエラーがあります。");
		}

	}
}
