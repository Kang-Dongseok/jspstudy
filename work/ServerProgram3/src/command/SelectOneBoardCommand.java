package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

public class SelectOneBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		long no = Long.parseLong(request.getParameter("no"));
		
		BoardDTO board = BoardDAO.getInstance().selectOneBoardByNo(no);
		
		HttpSession session = request.getSession();
		if (session.getAttribute("open") == null) {
			session.setAttribute("open", "open");
			BoardDAO.getInstance().updateHit(no);
	    }

		List<ReplyDTO> replyList = BoardDAO.getInstance().selectListReply(no); 
		
		request.setAttribute("board", board);
		request.setAttribute("replyList", replyList);

		ModelAndView mav = new ModelAndView("viewBoard.jsp", false);  // forward
		return mav;
		
	}

}