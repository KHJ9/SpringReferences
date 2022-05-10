package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyFirstFilter implements Filter {

	String initParam;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("첫 번째 필터링이 생성되었습니다.");
		initParam = filterConfig.getInitParameter("dummy") + " [1]";
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("필터링을 시작합니다.");
		request.setAttribute("dummy", initParam);
		chain.doFilter(request, response);
		log.info("필터링을 완료합니다 : " + initParam);
	}	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("첫 번째 필터링이 제거되었습니다.");
	}
	
}
