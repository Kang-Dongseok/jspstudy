package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class UpdatePwPageCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 비밀번호를 수정할 수 있는 updatePw.jsp로 이동
		return new ModelAndView("/10_MODEL2/member/updatePw.jsp", true);
	}

}