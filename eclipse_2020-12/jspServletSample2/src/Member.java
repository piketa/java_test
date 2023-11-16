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
		}
		if (errsname_zenkaku.size() > 0) {
			for (int i = 0; i < errsname_zenkaku.size(); i++) {
				buf.append("<li>" + errsname_zenkaku.get(i) + "</li>");
			}
		}
		if (errsname_mojinumber.size() > 0) {
			for (int i = 0; i < errsname_zenkaku.size(); i++) {
				buf.append("<li>" + errsname_zenkaku.get(i) + "</li>");
			}
		}
		if (errsold.size() > 0) {
			for (int i = 0; i < errsold.size(); i++) {
				buf.append("<li>" + errsold.get(i) + "</li>");
			}
		}
		if (errsgender.size() > 0) {
			for (int i = 0; i < errsgender.size(); i++) {
				buf.append("<li>" + errsgender.get(i) + "</li>");
			}
		}
		buf.append("</ul>");
		return buf.toString();
	}

	//全角判定
	boolean check_zenkaku = true;

	private boolean check_zenkaku(String value) {
		if (!value.matches("^[^ -~｡-ﾟ]+$")) {
			check_zenkaku = false;
			return check_zenkaku;
		}
		return check_zenkaku;
	}

	//全角判定メッセージ
	public void requiredCheckName_zenkaku(String value) {
		if (!check_zenkaku(value))
			errsname_zenkaku.add("文字が全角ではありません。");
	}

	public void MandatoryCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("Name");
		String old = request.getParameter("Old");
		String gender_select = request.getParameter("Gender_select");
		String gender = request.getParameter("Gender");

		if (!check_zenkaku) {
			requiredCheckName_zenkaku(request.getParameter(name));
			request.setAttribute("error_msg_name_zenkaku", getErrorList());
			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
			dispatch.forward(request, response);
		} else {
			request.setAttribute("fromName", name);
			request.setAttribute("fromOld", old);
			request.setAttribute("fromGender_select", gender_select);
			request.setAttribute("fromGender", gender);
			RequestDispatcher dispatch = request.getRequestDispatcher("confirm.jsp");
			dispatch.forward(request, response);

		}
	}
}