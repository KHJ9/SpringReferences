package kr.or.ddit.controller.mvcPrinciple;;

public class ViewResolver {
	
	public String prefix;
	public String postfix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	
	public String getView(String viewName) {
		return this.prefix + viewName + this.postfix;
	}
	
}
