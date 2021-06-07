package command;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controller.ModelAndView;
import dao.MemberDAO;
import dto.Member;

public class SelectMemberListCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 전체 회원 수
		int totalRecord = MemberDAO.getInstance().getMemberCount();

		// beginRecord, endRecord 구하기
		
		
		// beginRecord ~ endRecord 목록 가져오기
		List<Member> list = MemberDAO.getInstance().selectMemberList();
		
		// JSP로 반환할 결과 JSON
		JSONObject obj = new JSONObject();
		
		// 페이지 관련 변수만 저장할 JSON
		JSONObject paging = new JSONObject();
		paging.put("totalRecord", totalRecord);
		
		obj.put("paging", paging);
		
		if (list.size() > 0) {  // 목록이 있으면,
			JSONArray arr = new JSONArray();
			for (Member member : list) {
				JSONObject obj2 = new JSONObject();
				obj2.put("no", member.getNo());
				obj2.put("id", member.getId());
				obj2.put("name", member.getName());
				obj2.put("gender", member.getGender());
				obj2.put("address", member.getAddress());
				arr.add(obj2);
			}
			obj.put("list", arr);
			obj.put("isExist", true);
			// System.out.println(obj.toJSONString());
		} else {
			obj.put("isExist", false);
		}
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

}