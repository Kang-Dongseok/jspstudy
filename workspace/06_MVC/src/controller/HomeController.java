package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DateService;
import model.HomeService;
import model.TimeService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.do")  // .do로 끝나는 모든 요청(시작 슬래시가 없음에 주의)
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request, response 기본 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 확인 과정
		String requestURI = request.getRequestURI();  /***  requestURI: /06_MVC/date.do  ***/   
		String[] arr = requestURI.split("/");  /*** arr: {"", "06_MVC", "date.do"} ***/
		String command = arr[arr.length - 1];  /*** command: "date.do" ***/
		
		// 요청에 따른 MODEL의 선택과 호출
		HomeService service = null;  // 모든 Service들의 인터페이스
		String path = null;
		switch (command) {
		case "date.do":
			service = new DateService();  // MODEL을 선택하고 
			path = service.execute(request, response);  // 해당 MODEL을 호출
			break;
		case "time.do":
			service = new TimeService();
			path = service.execute(request, response);
			break;
		}
		
		// MODEL의 호출 결과(응답VIEW)에 따른 페이지 이동
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