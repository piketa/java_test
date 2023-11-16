import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	//        public Member() {
	//                super();
	// TODO Auto-generated constructor stub
	//        }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//##### GET時の必須入力チェックの実行
		MandatoryCheck(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	//##### エラーメッセージを格納するためのArrayList
	public ArrayList<String> errsname = new ArrayList<String>();
	public ArrayList<String> errsname_zenkaku = new ArrayList<String>();
	public ArrayList<String> errsname_mojinumber = new ArrayList<String>();
	public ArrayList<String> errsold = new ArrayList<String>();
	public ArrayList<String> errsgender = new ArrayList<String>();

	//エラー時の文字入力値
	public String getErrorList() {
		StringBuffer buf = new StringBuffer();
		buf.append("<ul style='color:Red'>");
		if (errsname.size() > 0) {
			for (int i = 0; i < errsname.size(); i++) {
				buf.append("<li>" + errsname.get(i) + "</li>");
			}
		} else if (errsold.size() > 0) {
			for (int i = 0; i < errsold.size(); i++) {
				buf.append("<li>" + errsold.get(i) + "</li>");
			}
		} else if (errsgender.size() > 0) {
			for (int i = 0; i < errsgender.size(); i++) {
				buf.append("<li>" + errsgender.get(i) + "</li>");
			}
		}
		buf.append("</ul>");
		return buf.toString();
	}

	//文字入力上限判定
	boolean check_mojinumber = true;
	private boolean check_mojinumber(String value, int minimumLength) {
		if (value.length() < minimumLength)
			check_mojinumber = false;
		return check_mojinumber;
	}

	//全角判定
	boolean check_zenkaku = false;
	private boolean check_zenkaku(String value) {
		byte[] bytes = value.getBytes();
		if (value.length() != bytes.length) {
			check_zenkaku = true;
			return check_zenkaku;
		}
		return check_zenkaku;
	}

	//氏名入力NULL判定
	public void requiredCheckName(String value) {
		if (value == null || value.trim().isEmpty()) {
			errsname.add(" 名前を入力してください。");
		}
	}

	//全角判定
	public void requiredCheckName_zenkaku(String value) {
		if (!check_zenkaku(value))
			errsname_zenkaku.add("文字が全角ではありません。");
	}


	//文字入力上限判定
	public void requiredCheckName_mojinumber(String value) {
		if (!check_mojinumber(value, 20)) {
			errsname_mojinumber.add(" ２０字以内の文字数で入力してください。");
		}
	}


	public void requiredCheckOld(String value) {
		if (value == null || value.trim().isEmpty()) {
			errsold.add(" 年齢を入力してください。");
		}
	}

	public void requiredCheckCustom(String value) {
		if (value == null || value.trim().isEmpty()) {
			errsold.add("カスタムを選択した場合は入力してください。");
		}
	}

	public void MandatoryCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("Name");
		String old = request.getParameter("Old");
		String gender_select = request.getParameter("Gender_select");
		String gender = request.getParameter("Gender");

		if (name == null || name == "") {
			requiredCheckName(request.getParameter("Name"));
			request.setAttribute("error_msg_name", getErrorList());
			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
			dispatch.forward(request, response);
		} else if (check_zenkaku = true) {
			requiredCheckName_zenkaku(request.getParameter("Name"));
			request.setAttribute("error_msg_name_zenkaku", getErrorList());
			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
			dispatch.forward(request, response);
		} else 	if (check_mojinumber = false) {
			requiredCheckName_mojinumber(request.getParameter("Name"));
			request.setAttribute("error_msg_name_mojinember", getErrorList());
			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
			dispatch.forward(request, response);
		} else {
			//##### バリデーションの結果問題なければ、次画面に遷移する
			request.setAttribute("fromName", name);
			request.setAttribute("fromOld", old);
			request.setAttribute("fromGender_select", gender_select);
			request.setAttribute("fromGender", gender);
			RequestDispatcher dispatch = request.getRequestDispatcher("confirm.jsp");
			dispatch.forward(request, response);
		}
	}

}
