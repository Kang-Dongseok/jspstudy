package command;

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

public class SelectListCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int totalRecord = BoardDAO.getInstance().getTotalRecord();
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		int recordPerPage = 5;
		int beginRecord = (page - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		if (endRecord > totalRecord) {
			endRecord = totalRecord;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord", beginRecord);
		map.put("endRecord", endRecord);
		
		List<BoardDTO> list = BoardDAO.getInstance().selectList(map);
		
		String paging = Paging.getPaging("/11_MYBATIS/selectList.do", totalRecord, recordPerPage, page);
		
		request.setAttribute("list", list);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("paging", paging);
		request.setAttribute("seq", totalRecord - (page - 1) * recordPerPage);
		
		return new ModelAndView("board/selectList.jsp", false);  // 포워드
		
	}

}