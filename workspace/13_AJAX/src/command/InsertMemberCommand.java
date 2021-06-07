package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import controller.ModelAndView;
import dao.MemberDAO;
import dto.Member;

public class InsertMemberCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String strMember = request.getParameter("member");
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject)parser.parse(strMember);
		
		Member member = new Member();
		member.setId( obj.get("id").toString() );
		member.setName( obj.get("name").toString() );
		member.setGender( obj.get("gender").toString() );
		member.setAddress( obj.get("address").toString() );
		
		int result = MemberDAO.getInstance().insertMember(member);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("isSuccess", result > 0);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj2);
		return null;
		
	}

}