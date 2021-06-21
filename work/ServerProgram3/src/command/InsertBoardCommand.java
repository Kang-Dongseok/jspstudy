package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = null;
		
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// DB로 보낼 DTO
		BoardDTO dto = new BoardDTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setIp(request.getRemoteAddr());
		
		int result = BoardDAO.getInstance().insertBoard(dto);
		System.out.println(result);
		try {
			PrintWriter out = response.getWriter();
			if (result == 0) {
				out.println("<script>");
				out.println("alert('게시글이 등록되지 않았습니다.')");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('게시글이 등록되었습니다.')");
				out.println("</script>");
				mav = new ModelAndView("/ServerProgram3/selectBoardList.do", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}





