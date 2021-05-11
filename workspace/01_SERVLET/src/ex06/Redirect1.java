package ex06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirect1
 */
@WebServlet("/Redirect1")
public class Redirect1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리다이렉트 처리
		
		// 1. 클라이언트에게 다시 이동할 주소를 알려준다. (응답이 처리하고, 주소는 '/컨텍스트패스/매핑')
		// 2. 클라이언트는 새 주소를 가지고 다시 이동한다. (주소창이 바뀐다.)
		// 3. 새로운 이동(새로운 요청: 새로운 request)이기 때문에 현재 request에 저장된 파라미터 name은 전달되지 않는다.
		
		response.sendRedirect("/01_SERVLET/Redirect2");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}