package kr.or.ddit.controller.mvcPrinciple;

public class MyController implements Controller {

	@Override
	public String handleRequest() {
		// view 네임을 반환한다.
		return "aaa";
	}

}
