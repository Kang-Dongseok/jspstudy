package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import controller.ModelAndView;
import dao.MemberDAO;

public class DeleteMemberCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long no = Long.parseLong(request.getParameter("no"));
		
		int result = MemberDAO.getInstance().deleteMember(no);
		
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", result > 0);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		
		return null;
		
	}

}