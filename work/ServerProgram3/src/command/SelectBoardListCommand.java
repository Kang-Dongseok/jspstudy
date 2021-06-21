package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class SelectBoardListCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}

		int totalRecord = BoardDAO.getInstance().getTotalBoardCount();
		
		List<BoardDTO> list = BoardDAO.getInstance().selectList();
		
		
		request.setAttribute("list", list);
		request.setAttribute("totalRecord", totalRecord);
		
		ModelAndView mav = new ModelAndView("/listBoard.jsp", false);
		return mav;
	}

}
