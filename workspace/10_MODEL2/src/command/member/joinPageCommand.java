package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class joinPageCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입을 할 수 있는 join.jsp로 이동
		return new ModelAndView("/10_MODEL2/member/join.jsp", true);
	}

}
