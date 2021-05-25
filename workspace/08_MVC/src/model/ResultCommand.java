package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class ResultCommand implements HomeCommand {

	@Override
	// public String execute(HttpServletRequest request, HttpServletResponse response) {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		double average = (kor + eng + mat) / 3.0;
		request.setAttribute("average", average);
		char grade;
		if (average >= 90) {
			grade = 'A';
		} else if (average >= 80) {
			grade = 'B';
		} else if (average >= 70) {
			grade = 'C';
		} else if (average >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		request.setAttribute("grade", grade);
		return new ModelAndView("views/output.jsp", false);
	}

}
