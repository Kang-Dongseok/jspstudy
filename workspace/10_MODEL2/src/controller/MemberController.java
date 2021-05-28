package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberCommand;
import common.ModelAndView;

@WebServlet("*.m")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 기본 처리(요청과 응답)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 확인
		// request.getRequestURI() == "/10_MODEL2/loginPage.m"
		// request.getRequestURI().split("/") == {"", "10_MODEL2", "loginPage.m"}
		// split() 결과 배열의 마지막 요소(인덱스: 길이-1)
		String[] arr = request.getRequestURI().split("/");
		String cmd = arr[arr.length - 1];  // cmd == "loginPage.m"
		
		// 요청을 전달하면 그 요청을 처리할 Model(Command)을 반환하는 CommandMapper 클래스를 통해 Command를 받음
		MemberCommand command = CommandMapper.getInstance().getCommand(cmd);
		ModelAndView mav = null;
		if (command != null) {
			mav = command.execute(request, response);
		}
		// Command의 반환이 null인 경우
		if (mav == null) {
			return; // doGet() 메소드 종료(Controller의 종료: Command의 null 반환은 Command가 다 처리하고 이동할 페이지가 없음을 의미)
		}
		// 페이지 이동
		if (mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
