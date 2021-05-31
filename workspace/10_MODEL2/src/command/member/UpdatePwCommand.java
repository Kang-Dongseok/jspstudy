package command.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdatePwCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 처리
		String pw = request.getParameter("pw");
		// session에서 loginDTO 정보 알아내기
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		// DB로 보낼 DTO
		MemberDTO dto = new MemberDTO();
		dto.setPw(pw);
		dto.setNo(loginDTO.getNo());
		// DAO의 updatePw() 메소드 호출
		int result = MemberDAO.getInstance().updatePw(dto);
		try {
			PrintWriter out = response.getWriter();
			if (result > 0) {
				// session의 loginDTO 업데이트
				loginDTO.setPw(pw);
				// 응답 및 이동
				out.println("<script>");
				out.println("alert('비밀번호가 변경되었습니다.')");
				out.println("location.href = '/10_MODEL2/index.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('비밀번호가 수정되지 않았습니다.')");
				out.println("location.href = '/10_MODEL2/myPage.m'");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}


