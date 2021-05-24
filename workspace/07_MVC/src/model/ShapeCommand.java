package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface ShapeCommand {
	
	// 응답View만 반환
	// public String execute(HttpServletRequest request, HttpServletResponse response);
	
	// 응답View + 이동방식 반환
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response);
}
