package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.ReplyDTO;

public class InsertReplyCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		Long boardNo= Long.parseLong(request.getParameter("no"));
		
		ReplyDTO dto = new ReplyDTO();
		dto.setAuthor(author);
		dto.setContent(content);
		dto.setBoardNo(boardNo);
		dto.setIp(request.getRemoteAddr());
		
		int result = BoardDAO.getInstance().insertReply(dto);
		
		ModelAndView mav = null;
		try {
			PrintWriter out = response.getWriter();
			if (result == 0) {
				out.println("<script>");
				out.println("alert('댓글이 등록되지 않았습니다.')");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('댓글이 등록되었습니다.')");
				out.println("</script>");
				mav = new ModelAndView("/ServerProgram3/selectOneBoard.do?no=" + boardNo, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;

	}

}