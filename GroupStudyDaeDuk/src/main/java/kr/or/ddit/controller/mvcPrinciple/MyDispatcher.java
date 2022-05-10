package kr.or.ddit.controller.mvcPrinciple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 스프링 내부의 MVC 패턴 구현방식을 이해하기 위한 예시구조
@WebServlet("*.do")
public class MyDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 
	 Dispatcher의 목적
	 
	 1. HandlersMappiing을 통해 컨트롤러를 받는다.
	 2. Controller를 통해 view이름을 받는다.
	 3. ViewResolver를 통해 view를 얻는다.
	 4. view 출력
	 
	 스프링은 선언적 프로그램이다.
	 어노테이션을 통해 스프링에 지시를 내릴 수 있다.
	 
	 */
	
	private HandlersMapping handlersMapping = new HandlersMapping();
	private ViewResolver viewResolver = new ViewResolver();
	
    public MyDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // init 메소드 객체가 생성되고 바로 실행되는 초기화 블럭
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	handlersMapping.getMappings().put("aaa.do", new MyController());
    	viewResolver.setPrefix("/WEB-INF/views/");
    	viewResolver.setPostfix(".jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URI vs URL
		String reqUrl = request.getRequestURI();
		String path = reqUrl.substring(reqUrl.lastIndexOf("/")+1);
		System.out.println(path);
		
		Controller ctrl = handlersMapping.getMappings().get(path);
		System.out.println("controller:"+ctrl);
		String viewName = ctrl.handleRequest();
		System.out.println("viewName:"+viewName);
		String viewPath = viewResolver.getView(viewName); // 전체 경로 반환
		System.out.println("viewPath:"+viewPath);
		
		// 만약 무언가를 담아서 보내고 싶다면
		request.setAttribute("message", "Hello Spring");
		
		// 포워딩
		request.getRequestDispatcher(viewPath).forward(request, response);
	}

}
