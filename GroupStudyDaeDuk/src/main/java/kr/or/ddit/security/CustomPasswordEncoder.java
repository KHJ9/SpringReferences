package kr.or.ddit.security;

import org.springframework.security.crypto.password.PasswordEncoder;

// 껍데기만 암호화하는 것 처럼 보이는 Encoder제작
public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		return rawPassword.toString(); // 있는 그대로 암호 반환
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		// 간단하게 문자열로 비교하도록 작성함
		return rawPassword.toString().equals(encodedPassword);
	}

}
