package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class LoginPageCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인을 할 수 있는 login.jsp로 이동
		return new ModelAndView("/10_MODEL2/member/login.jsp", true);
	}

}
