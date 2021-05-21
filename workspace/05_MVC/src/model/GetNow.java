package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class GetNow {

	public String execute(HttpServletRequest request) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
		request.setAttribute("now", sdf.format(now));
		
		return "views/output.jsp";
		
	}
}