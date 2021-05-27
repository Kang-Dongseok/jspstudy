package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface MemberCommand {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response);
}
