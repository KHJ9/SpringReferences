package kr.or.ddit.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import kr.or.ddit.domain.MemberVO;
import kr.or.ddit.security.CustomUser;

public class CustomUtil {

	public static MemberVO getSessionVO() {
		SecurityContext context = SecurityContextHolder.getContext();
		CustomUser customUser = (CustomUser)context.getAuthentication().getPrincipal();
		MemberVO member = customUser.getMember();
		return member;
	}
	
}
