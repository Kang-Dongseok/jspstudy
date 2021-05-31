package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.board.BoardCommand;
import common.ModelAndView;

@WebServlet("*.b")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		/*
		String[] arr = request.getRequestURI().split("/");
		String cmd = arr[arr.length - 1];
		 */
		String requestURI = request.getRequestURI();	// /10_MODEL2/insertBoard.b
		String contextPath = request.getContextPath();  // /10_MODEL2 
		String cmd = requestURI.substring(contextPath.length() + 1);  // insertBoard.b
		BoardCommand command = BoardCommandMapper.getInstance().getCommand(cmd);
		
		/*
		 * switch(cmd) { }
		 */
		
		ModelAndView mav = null;
		if (command != null) {
			mav = command.execute(request, response);
		}
		
		if (mav == null) {
			return;
		}
		if (mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
