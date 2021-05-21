package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetToday;

/**
 * Servlet implementation class DateController
 */
@WebServlet("/DateController")
public class DateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input.jsp의 요청이 오는 곳
		
		// CONTROLLER
		// 1. 요청 확인
		// 2. 해당 요청을 처리할 MODEL(POJO: 순수자바) 호출
		// 3. MODEL 실행 결과
		//    1) 결과값 (현재날짜)
		//    2) 응답VIEW (결과값을 보여 줄 JSP)
		// 4. 응답VIEW로 페이지 이동
		
		GetToday getToday = new GetToday();
		String path = getToday.execute(request);  // CONTROLLER의 request를 MODEL에게 전달
		
		// 결과값이 저장된 request를 가지고 path(views/output.jsp)로 이동해야 한다.
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}