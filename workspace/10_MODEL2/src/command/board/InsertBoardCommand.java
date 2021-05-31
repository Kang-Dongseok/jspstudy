package command.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부파일이 저장될 디렉터리
		final String DIRECTORY = "archive";
		String realPath = request.getServletContext().getRealPath(DIRECTORY);
		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		ModelAndView mav = null;
		MultipartRequest multipartRequest = null;
		try {
			// 업로드 진행
			multipartRequest = new MultipartRequest(request, 
													realPath, 
													1024 * 1024 * 10, 
													"utf-8",
													new DefaultFileRenamePolicy());
			// 파라미터 처리 : MultipartRequest가 담당
			String author = multipartRequest.getParameter("author");
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			String ip = multipartRequest.getParameter("ip");
			String filename = null;
			if (multipartRequest.getFile("filename") == null) {  // 첨부가 없다.
				filename = "";
			} else {
				filename = multipartRequest.getFilesystemName("filename");
			}
			// DB로 보낼 DTO
			BoardDTO dto = new BoardDTO();
			dto.setAuthor(author);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setFilename(filename);
			dto.setIp(ip);
			// DAO의 insertBoard() 메소드 호출
			int result = BoardDAO.getInstance().insertBoard(dto);
			if (result == 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('게시글이 저장되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				mav = new ModelAndView("/10_MODEL2/selectListBoardPage.b", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}





