package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LogoutCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// session의 loginDTO의 로그아웃 기록을 위해 id 추출
		HttpSession session = request.getSession();
		String id = ((MemberDTO)session.getAttribute("loginDTO")).getId();
		// DAO의 logoutLog() 호출
		MemberDAO.getInstance().logoutLog(id);
		// session 초기화
		session.invalidate();
		// 어디로, 어떻게
		return new ModelAndView("/10_MODEL2/index.do", true);  // true는 redirect
	}

}