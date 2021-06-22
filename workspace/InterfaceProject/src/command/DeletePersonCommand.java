package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.PersonDAO;

@WebServlet("/deletePerson.do")
public class DeletePersonCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeletePersonCommand() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sno = request.getParameter("sno");
		int count = PersonDAO.getInstance().deletePerson(sno);
		JSONObject obj = new JSONObject();
		obj.put("count", count);
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(obj);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}