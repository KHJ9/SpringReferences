package kr.or.ddit.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

// 인증성공시, 보통 어디로 보낼지를 결정(관리자면 관리자페이지, 일반회원이면 메인페이지로...)
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {@Override

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Iterator<? extends GrantedAuthority> myIter = auth.getAuthorities().iterator();
		log.info("name : " + auth.getName());
		log.info("credentials : " + auth.getCredentials());
		log.info("details : " + auth.getDetails());
		log.info("principal : " + auth.getPrincipal());
		
		while(myIter.hasNext()) {
			String authName = myIter.next().toString();
			log.info("auth : " + authName); // 어떤 권한이 넘어오는지 확인
			if(authName.equals("ROLE_ADMIN"))
				response.sendRedirect(request.getContextPath()+"/fbi/admin");
			else if(authName.equals("ROLE_MEMBER"))
				response.sendRedirect(request.getContextPath()+"/fbi/member");
			else if(authName.equals("ROLE_BLUE"))
				response.sendRedirect(request.getContextPath()+"/fbi/blue");
			break;
		}
		
		// ex)
		// name : blue
		// credentials : blue
		// details : org.springframework.security.web.authentication.WebAuthenticationDetails@b364: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: AAA3FF5B55FC75AFAD0BC8C14CA337B7
		// principal : org.springframework.security.core.userdetails.User@2e305a: Username: blue; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_BLUE
		// auth : ROLE_BLUE, ROLE_MEMBER, ...
	}

}
