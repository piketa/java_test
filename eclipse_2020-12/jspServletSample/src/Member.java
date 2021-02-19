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
	public ArrayList<String> errsold = new ArrayList<String>();
	public ArrayList<String> errsgender = new ArrayList<String>();

	//[Common] Transform the error ArrayList to a <ul> list
	//##### getErrorList()メソッド：【必須入力チェック】
	//##### エラーメッセージを格納したArrayList「errs」のメッセージをHTML形式に整形（タグを付与）したり、文字色 を赤くする処理をしています。
	//##### StringBuffer型の変数に格納していき、その結果を戻り値にしています。
	public String getErrorList() {
		StringBuffer buf = new StringBuffer();
		buf.append("<ul style='color:Red'>");
		if (errsname.size() > 0) {
			for (int i = 0; i < errsname.size(); i++) {
				buf.append("<li>" + errsname.get(i) + "</li>");
			}
		}
		buf.append("</ul>");
		return buf.toString();
	}

	public void requiredCheckName(String value) {
		//もし「引数（value）がnull」OR「引数（value）の空白削除値が空」なら
		if (value == null || value.trim().isEmpty()) {
			//入力値がブランクであると見なし、入力を求めるメッセージを出力
			errsname.add(" 名前を入力してください。");
		}
	}

	public void requiredCheckOld(String value) {
		//もし「引数（value）がnull」OR「引数（value）の空白削除値が空」なら
		if (value == null || value.trim().isEmpty()) {
			//入力値がブランクであると見なし、入力を求めるメッセージを出力
			errsold.add(" 年齢を入力してください。");
		}
	}

	public void requiredCheckCustom(String value) {
		//もし「引数（value）がnull」OR「引数（value）の空白削除値が空」なら
		if (value == null || value.trim().isEmpty()) {
			//入力値がブランクであると見なし、入力を求めるメッセージを出力
			errsold.add("カスタムを選択した場合は入力してください。");
		}
	}

	public void MandatoryCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		errsname = new ArrayList<String>();
		errsold = new ArrayList<String>();
		errsgender = new ArrayList<String>();

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
//ここのif文がうまく表示されていないのでコメントアウト
//		} else if (old == null || old == "") {
//			requiredCheckName(request.getParameter("Old"));
//			request.setAttribute("error_msg_old", getErrorList());
//			RequestDispatcher dispatch = request.getRequestDispatcher("member.jsp");
//			dispatch.forward(request, response);
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
