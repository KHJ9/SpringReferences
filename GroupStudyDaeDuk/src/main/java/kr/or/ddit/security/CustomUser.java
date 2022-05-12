package kr.or.ddit.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.domain.AuthVO;
import kr.or.ddit.domain.MemberVO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter // 외부에서 MemberVO를 읽어들이기 위해 Getter를 선언했다.
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	private MemberVO member;
	
	// 생성자에서 부모 생성자를 불러줘야 함
	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// 이 생성자가 MemberVO를 UserDetails로 만들어주는 생성자
	// UserDetails는 기본적으로 username, password, authorities을 가지고 있는데
	// 거기에다 살짝 우리의 memberVO를 붙여주려 함(이 클래스의 핵심)
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(), 
			vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		List<SimpleGrantedAuthority> ckList = 
			vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList());
		
		// 시간 날 때 stream 어렵지 않으니, 한 번 손에 익히기
		// 중간 오퍼레이션 함수와 종료 오퍼레이션 함수만 잘 구분해서
		// 위 stream 방식을 일반 반복문으로 처리시.
		List<AuthVO> myList = vo.getAuthList();
		List<SimpleGrantedAuthority> ck2List = new ArrayList<SimpleGrantedAuthority>();
		
		for (AuthVO authVO : myList) {
			ck2List.add(new SimpleGrantedAuthority(authVO.getAuth()));
		}
		
		log.info("stream result : " + ckList);
		log.info("just check : " + ck2List);
		
		this.member = vo;		
	}
	
}















