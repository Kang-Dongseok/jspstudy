package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TimeService 클래스는
// 타입이 2개이다.
// TimeService, HomeService

public class TimeService implements HomeService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
		request.setAttribute("time", sdf.format(date));
		
		return "views/output.jsp";
		
	}
	
}