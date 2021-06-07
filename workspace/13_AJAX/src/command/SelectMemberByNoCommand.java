package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import controller.ModelAndView;
import dao.MemberDAO;
import dto.Member;

public class SelectMemberByNoCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long no = Long.parseLong(request.getParameter("no"));
		
		Member member = MemberDAO.getInstance().selectMemberByNo(no);
		
		JSONObject obj = new JSONObject();
		if (member != null) {
			obj.put("no", member.getNo());
			obj.put("id", member.getId());
			obj.put("name", member.getName());
			obj.put("gender", member.getGender());
			obj.put("address", member.getAddress());
			obj.put("isExist", true);
		} else {
			obj.put("isExist", false);
		}
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

}