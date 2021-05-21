package model;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class GetLotto {

	public String execute(HttpServletRequest request) {
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		while (lotto.size() < 6) {
			lotto.add( (int)(Math.random() * 45) + 1 );
		}
		
		request.setAttribute("lotto", lotto);
		
		return "views/output.jsp";
		
	}
	
}