package model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class GetToday {

	// MODEL
	// 1. 비즈니스 로직을 처리한다.
	// 2. Command, Service 등으로 불린다.
	// 3. 요청을 받기 위해서 request를 사용할 수 있어야 한다.
	// 4. MODEL이 결과를 처리하는 방식
	//    1) 결과값 : CONTROLLER가 넘겨 준 request에 저장(CONTROLLER에서 결과값을 확인할 수 있다.)
	//    3) 응답VIEW : 직접 반환한다.
	
	public String execute(HttpServletRequest request) {
		
		// 1. 현재 날짜를 구한다.
		Date today = new Date();
		request.setAttribute("today", today);
		
		// 2. 응답VIEW를 반환한다.
		return "views/output.jsp";
		
	}
	
}