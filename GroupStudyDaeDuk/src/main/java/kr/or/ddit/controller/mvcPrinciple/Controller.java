package kr.or.ddit.controller.mvcPrinciple;

// 많은 갯수의 컨트롤러가 존재하니 통일성을 위해서 
public interface Controller {
	
	// 요청을 핸들하는 메소드
	public String handleRequest();
	
}
