package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HomeCommand {
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
