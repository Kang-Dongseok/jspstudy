package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;

public class JoinCommand implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		MemberDAO.getInstance().join(id, name);
		
		return new ModelAndView("/ServerProgram1/login.jsp", true);
		
	}

}