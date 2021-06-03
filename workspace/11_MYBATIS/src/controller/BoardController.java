package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BoardCommand;
import command.DeleteCommand;
import command.FindListCommand;
import command.InsertCommand;
import command.InsertPageCommand;
import command.InsertReplyCommand;
import command.InsertReplyCommand2;
import command.InsertReplyCommand3;
import command.InsertReplyPageCommand;
import command.SelectListCommand1;
import command.SelectListCommand2;
import command.SelectListCommand3;
import common.ModelAndView;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String[] arr = request.getRequestURI().split("/");
		String cmd = arr[arr.length - 1];
		
		ModelAndView mav = null;
		BoardCommand command = null;
		switch (cmd) {
		case "selectList1.do":
			command = new SelectListCommand1();
			break;
		case "selectList2.do":
			command = new SelectListCommand2();
			break;
		case "selectList3.do":
			command = new SelectListCommand3();
			break;
		case "insertPage.do":
			command = new InsertPageCommand();
			break;
		case "insert.do":
			command = new InsertCommand();
			break;
		case "insertReplyPage.do":
			command = new InsertReplyPageCommand();
			break;
		case "insertReply.do":
			command = new InsertReplyCommand();
			break;
		case "insertReply2.do":
			command = new InsertReplyCommand2();
			break;
		case "insertReply3.do":
			command = new InsertReplyCommand3();
			break;
		case "findList.do":
			command = new FindListCommand();
			break;
		case "delete.do":
			command = new DeleteCommand();
			break;
		}
		
		if (command != null) {
			try {
				mav = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}