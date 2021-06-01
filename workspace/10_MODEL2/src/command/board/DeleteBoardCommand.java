package command.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 처리
		long idx = Long.parseLong(request.getParameter("idx"));
		
		/*
			삭제의 고찰
			1. DELETE : 댓글이 달려 있는지 점검해야 한다. 댓글이 달려 있으면 못 지운다.
			2. UPDATE : 댓글이 삭제 상태라고 수정하면 된다.
		*/
		
		// 삭제를 UPDATE로 처리
		
		// DAO의 deleteBoard() 메소드 호출
		int result = BoardDAO.getInstance().deleteBoard(idx);
		ModelAndView mav = null;
		try {
			if (result == 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				mav = new ModelAndView("/10_MODEL2/selectListBoardPage.b", true);  // redirect
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
		
	}

}