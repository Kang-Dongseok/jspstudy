package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.ModelAndView;
import dao.MemberDAO;

public class IdCheckCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		// 사용가능 ID : result = true
		boolean result = MemberDAO.getInstance().idCheck(id);
		
		// 응답 데이터를 JSON 데이터 타입으로 생성
		JSONObject obj = new JSONObject();
		obj.put("result", result);  // {"result": true} 또는 {"result": false}
		
		// 응답 데이터를 곧바로 응답 처리
		response.setContentType("application/json; charset=utf-8");  // JSON 데이터의 ContentType
		PrintWriter out = response.getWriter();
		out.println(obj);  // JSON 데이터 응답
		out.close();
		
		// controller로 ModelAndView()를 반환하지 않아야만 redirect 또는 forward 되지 않는다.
		return null;
		
	}

}