package login.captcha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 성공/실패 메시지는 경고창으로 작성
		// 응답 처리를 위해서 response의 처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 사용자 입력값 검증
		// 검증 결과에 따라서 이동할 페이지를 다르게 지정
		
		boolean result = CaptchaValidation.getValidate(request);
		if (result) {
			out.println("<script>");
			out.println("alert('검증에 성공했습니다.')");
			out.println("location.href = '/03_CAPTCHA/index.jsp'");
			out.println("</script>");
			// response.sendRedirect("/03_CAPTCHA/index.jsp");
		} else {
			out.println("<script>");
			out.println("alert('검증에 실패했습니다. 다시 시도하세요.')");
			out.println("location.href = '/03_CAPTCHA/Login'");
			out.println("</script>");
			// 메시지 없이 이동
			// response.sendRedirect("/03_CAPTCHA/Login");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
