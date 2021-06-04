package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertReplyCommand3 implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 대댓글 달기
		
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		long no = Long.parseLong(request.getParameter("no"));
		
		BoardDTO replyDTO = new BoardDTO();
		replyDTO.setAuthor(author);
		replyDTO.setTitle(title);
		replyDTO.setContent(content);
		replyDTO.setIp(ip);

		// 원글 정보 가져오기 (DAO 작업)
		BoardDTO boardDTO = BoardDAO.getInstance().selectBoard(no);
		
		// 가져온 원글(부모) 정보를 이용해서 replyDTO 생성
		replyDTO.setGroupno(boardDTO.getGroupno());
		replyDTO.setGroupord(boardDTO.getGroupord() + 1);
		replyDTO.setDepth(boardDTO.getDepth() + 1);
		
		// 같은 그룹의 기존 댓글들 중에서
		// groupord가 가져온 원글(부모)의 groupord보다 큰 댓글들의
		// groupord를 1씩 증가
		BoardDAO.getInstance().increaseGroupordOtherReply(boardDTO);
		
		// 댓글 삽입하기
		int result = BoardDAO.getInstance().insertReply(replyDTO);
		
		// 이동
		return new ModelAndView("/11_MYBATIS/board/insertReplyResult3.jsp?result=" + result, true);  // 삽입 후에는 반드시 리다이렉트한다.
		
	}

}