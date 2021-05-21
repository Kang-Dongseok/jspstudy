package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// DateService 클래스는
// 타입이 2개이다.
// DateService, HomeService

public class DateService implements HomeService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("date", sdf.format(date));
		
		return "views/output.jsp";
		
	}
	
}