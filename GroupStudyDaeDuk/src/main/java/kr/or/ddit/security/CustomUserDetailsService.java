package kr.or.ddit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.ddit.domain.MemberVO;
import kr.or.ddit.mapper.MemberMapper;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	MemberMapper memberMapper;
	
	// UserDetails : 스프링 시큐리티에서 사용자 정보로 사용될 유저 상세정보 클래스
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// 리턴타입이 UserDetails라서 MemberVO를 UserDetails로 바꾼다.
		// UserDetails를 구현한 User클래스가 있어서 User 클래스를 상속받아서 만들어주면 됨.
		System.out.println(username);
		MemberVO member = memberMapper.read(username);
		
		// 회원정보를 불러오지 못하면 null을 반환한다.
		return member == null ? null : new CustomUser(member);
	}
	
}
