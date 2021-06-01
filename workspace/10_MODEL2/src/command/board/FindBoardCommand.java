package command.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import common.Paging;
import dao.BoardDAO;
import dto.BoardDTO;

public class FindBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 처리
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		
		// DB로 보낼 Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("query", "%" + query + "%");
		
		// DAO의 getFindBoardCount() 메소드 호출
		// 검색 결과의 개수가 totalRecord
		int totalRecord = BoardDAO.getInstance().getFindBoardCount(map);
		
		// 검색 결과를 기반으로 페이징 처리
		// 페이지 수 처리하기(파라미터로 전달)
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 한 페이지에 표시할 게시글의 개수 : recordPerPage
		int recordPerPage = 5;
		
		// totalRecord, page, recordPerPage를 통해서
		// beginRecord, endRecord를 계산
		int beginRecord = (page - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		endRecord = (endRecord < totalRecord) ? endRecord : totalRecord;
		
		// DB로 보낼 Map
		map.put("beginRecord", beginRecord + "");
		map.put("endRecord", endRecord + "");
		
		// DAO의 selectFindList() 메소드 호출
		List<BoardDTO> list = BoardDAO.getInstance().selectFindList(map);
		
		// 페이징 처리
		// 검색 결과를 페이징 처리하는 경우
		// 검색 관련 파라미터를 Paging 클래스에 전달해야 한다.
		String paging = Paging.getPaging("/10_MODEL2/findBoard.b?column=" + column + "&query=" + query, totalRecord, recordPerPage, page);
		
		// 응답View로 전달할 데이터
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("seq", totalRecord - (page - 1) * recordPerPage);
		
		ModelAndView mav = new ModelAndView("/board/listBoard.jsp", false);  // 포워드 이동
		return mav;
		
	}

}