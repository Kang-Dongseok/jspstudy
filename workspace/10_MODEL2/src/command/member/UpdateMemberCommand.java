package command.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateMemberCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		// session에서 loginDTO 알아내기
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		// DB로 보낼 DTO
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setEmail(email);
		dto.setNo(loginDTO.getNo());
		// DAO의 updateMember() 메소드 호출
		int result = MemberDAO.getInstance().updateMember(dto);
		try {
			PrintWriter out = response.getWriter();
			if (result > 0) {
				// session의 loginDTO 업데이트
				loginDTO.setName(name);
				loginDTO.setEmail(email);
				// 응답 및 이동
				out.println("<script>");
				out.println("alert('회원정보가 수정되었습니다.')");
				out.println("location.href='/10_MODEL2/myPage.m'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원정보가 수정되지 않았습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}