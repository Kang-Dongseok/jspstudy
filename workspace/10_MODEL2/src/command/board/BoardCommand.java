package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public interface BoardCommand {
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response);
}
