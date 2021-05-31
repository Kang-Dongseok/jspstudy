package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class MyPageCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원정보를 수정할 수 있는 myPage.jsp로 이동
		return new ModelAndView("/10_MODEL2/member/myPage.jsp", true);
	}

}