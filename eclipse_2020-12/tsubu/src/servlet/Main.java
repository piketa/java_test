package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//�Ԃ₫���X�g���擾���āA���N�G�X�g�X�R�[�v�ɕۑ�
	GetMutterListLogic getMutterListLogic =
		new GetMutterListLogic();
	List<Mutter> mutterList = getMutterListLogic.execute();
	request.setAttribute("mutterList", mutterList);
	
	//���O�C�����Ă��邩�m�F���邽��
	//�Z�b�V�����X�R�[�v���烆�[�U�[�����擾
	HttpSession session = request.getSession();
	User loginUser = (User) session.getAttribute("loginUser");
	
	if(loginUser == null) { //���O�C�����Ă��Ȃ��ꍇ
		//���_�C���N�g
		response.sendRedirect("/tsubu/");
	} else { //���O�C���ς݂̏ꍇ
		//�t�H���[�h
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		//���N�G�X�g�p�����[�^�̎擾
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//���͒l�`�F�b�N
		if(text != null && text.length()  !=0) {
			
			//�Z�b�V�����X�R�[�v�ɕۑ����ꂽ���[�U�[�����擾
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//�Ԃ₫���Ԃ₫���X�g�ɒǉ�
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
								
		} else {
			//�G���[���b�Z�[�W�����N�G�X�g�X�R�[�v�ɕۑ�
			request.setAttribute("errorMsg","�Ԃ₫�����͂���Ă��܂���");
			
		}
		
		//�Ԃ₫���X�g���擾���āA���N�G�X�g�X�R�[�v�ɕۑ�
		GetMutterListLogic getMutterListLogic =
			new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		
		
		//���C����ʂɃt�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request,response);
	}
	
	

	
	
}
