package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class DeleteCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long no = Long.parseLong(request.getParameter("no"));
		
		int result = BoardDAO.getInstance().delete(no);
		
		return new ModelAndView("/11_MYBATIS/board/deleteResult.jsp?result=" + result, true);  // UPDATE 이후에는 리다이렉트
		
	}

}