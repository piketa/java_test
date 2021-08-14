package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dto.Employee;

/**
 *@author Akihiro Nakamura
 *ゲストログインクラスx
 */
@WebServlet("/GuestEmployeeLogin")
public class GuestEmployeeLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	*@see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*@param request クライアントがServletへ要求したリクエスト内容を含むHttpServletRequestオブジェクト
	*@param response Servletがクライアントに返すレスポンス内容を含むHttpServletResponseオブジェクト
	*@throws ServletException ServletException ServletがGetリクエストを処理中にServlet内で例外が発生
	*@throws IOException ServletがGetリクエストを処理中に入出力エラーが発生
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	*@see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*@param request クライアントがServletへ要求したリクエスト内容を含むHttpServletRequestオブジェクト
	*@param response Servletがクライアントに返すレスポンス内容を含むHttpServletResponseオブジェクト
	*@throws ServletException ServletがPostリクエストを処理中にServlet内で例外が発生
	*@throws IOException ServletがPostリクエストを処理中に入出力エラーが発生
	*データベースに接続してゲストとしてログイン<br>
	*ゲストとしてログインしたらセッションにゲスト情報をセットする。<br>
	*メインメニュー画面へ画面偏移する。
	*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションオブジェクトの生成
		HttpSession session = request.getSession();

		//ゲスト社員番号
		int number = 0;

		//ゲストログイン準備
		EmployeeDAO ed = new EmployeeDAO();
		Employee employee = new Employee();

		try {
			//データベース接続
			ed.dbConnect();

			//ゲストログイン
			employee = ed.loginGuest();

			//セッションスコープに保存
			session.setAttribute("employee",employee);
			session.setAttribute("number",number);

		}catch (SQLException e){
			e.printStackTrace();

		}finally{
			try{
				//データベースの切断
				ed.dbClose();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		if(employee != null ){
			//ゲストログイン
			RequestDispatcher disp = request.getRequestDispatcher("./WorkSelect");
			disp.forward(request, response);
		}else{
			//ゲストログイン失敗
			RequestDispatcher disp = request.getRequestDispatcher("login_error.jsp");
			disp.forward(request, response);
		}
	}
}
