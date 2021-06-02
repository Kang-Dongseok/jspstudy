package command.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class DeleteReplyCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 처리
		long replyIdx = Long.parseLong(request.getParameter("replyIdx"));  // 삭제할 댓글 번호
		long idx = Long.parseLong(request.getParameter("idx"));  // 삭제 후 되돌아갈 게시글 번호
		
		// DAO의 deleteReply() 메소드 호출
		int result = BoardDAO.getInstance().deleteReply(replyIdx);
		
		ModelAndView mav = null;
		try {
			if (result == 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('댓글이 삭제되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				mav = new ModelAndView("/10_MODEL2/selectOneBoard.b?idx=" + idx, true);  // redirect
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	
	}

}