package common;

public class ModelAndView {

	private String view;
	private boolean idRedirect;
	
	public ModelAndView() {}
	public ModelAndView(String view, boolean idRedirect) {
		super();
		this.view = view;
		this.idRedirect = idRedirect;
	}
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public boolean isIdRedirect() {
		return idRedirect;
	}
	public void setIdRedirect(boolean idRedirect) {
		this.idRedirect = idRedirect;
	}
	
}
