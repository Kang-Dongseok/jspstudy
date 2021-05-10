package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 * - 서블릿을 실행하면 웹 브라우저가 열린다.
 * - 웹 브라우저 URL은 http://localhost:포트번호/컨텍스트패스/URL매핑" 방식으로 구성된다.
 */
@WebServlet("/MyServlet")  // 이것이 URL매핑이다.
public class MyServlet extends HttpServlet {  // HttpServlet 클래스를 상속 받으면 서블릿이다.
	private static final long serialVersionUID = 1L;  // 직렬화를 위한 ID값이다. 여기서는 관심이 없다.
       
    /**
     * @see HttpServlet#HttpServlet()
     * 1. 생성자
     *    - 가장 먼저 호출된다.
     *    - 생성자가 호출된 뒤 init() 메소드가 호출된다.
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("생성자 호출");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 2. init() 메소드
	 *    - 최초 한 번만 호출된다.
	 *    - 초기화 용도이다.
	 *    - init() 메소드가 호출된 뒤 service() 메소드가 호출된다.
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init() 호출");
	}

	/**
	 * @see Servlet#destroy()
	 * 3. destroy() 메소드
	 *    - 서버에서 프로젝트가 소멸되면 호출된다.
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() 호출");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 4. service() 메소드
	 *    - 실제 처리를 수행할 수 있다.
	 *    - 매개변수1
	 *      1) HttpServletRequest request
	 *      2) 사용자의 요청을 처리하는 객체이다.
	 *      3) 사용자들이 요청한 파라미터(검색어, 아이디/비번 등), 사용자들의 접속 IP 등
	 *    - 매개변수2
	 *    	1) HttpServletResponse response
	 *    	2) 서버의 응답을 처리하는 객체이다.
	 *    	3) 사용자들의 요청을 처리한 결과(검색 결과, 로그인 성공 유무 등)
	 *    - service() 메소드가 없으면 doGet() 또는 doPost() 메소드가 호출된다. (기본값 doGet())
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service() 호출");
		if ( request.getMethod().equalsIgnoreCase("get") ) {  // 사용자의 요청이 get 방식이면
			doGet(request, response);
		} else if ( request.getMethod().equalsIgnoreCase("post") ) {  // 사용자의 요청이 post 방식이면
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 5. doGet()
	 *    - get 방식의 요청을 처리하는 메소드이다.
	 *    - get 방식의 요청
	 *    	1) 주소창(URL)으로 직접 요청
	 *    	2) <form method="get">
	 *    	3) $.ajax({ type: 'get' })
	 *    - service() 메소드를 사용하지 않는 경우 실제 처리는 doGet() 메소드가 한다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 호출");
		response.getWriter().append("Served at: ").append(request.getContextPath());  // 웹 브라우저에 보여 줄 결과 (response)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 6. doPost()
	 *    - post 방식의 요청을 처리하는 메소드이다.
	 *    - 실제로는 아무 처리도 하지 않고, 모든 처리를 doGet() 메소드에 위임한다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 호출");
		doGet(request, response);
	}

}
