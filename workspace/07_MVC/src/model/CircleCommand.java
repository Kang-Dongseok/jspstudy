package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class CircleCommand implements ShapeCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {

		double radius = 0;
		try {
			radius = Double.parseDouble(request.getParameter("radius"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("area", Math.PI * Math.pow(radius, 2));
		
		return new ModelAndView("views/output.jsp", false);
	}

}
