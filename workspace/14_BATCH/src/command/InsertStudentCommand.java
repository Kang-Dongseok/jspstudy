package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;
import dao.StudentDAO;
import dto.StudentDTO;

public class InsertStudentCommand implements StudentCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		double ave = (kor + eng + mat) / 3.0;
		char grade = 'F';
		if (ave >= 90) grade = 'A';
		else if (ave >= 80) grade = 'B';
		else if (ave >= 70) grade = 'C';
		else if (ave >= 60) grade = 'D';
		
		StudentDTO dto = new StudentDTO(sno, name, kor, eng, mat, ave, grade);
		
		int result = StudentDAO.getInstance().insertStudent(dto);
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('학생 정보가 등록되었습니다.')");
			out.println("location.href='/14_BATCH/selectStudentList.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('학생 정보가 등록되지 않았습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	
		return null;
	}

}