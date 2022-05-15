package kr.or.ddit.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class) // Junit5 : 단위테스트용 프레임워크
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class PasswordEncoderTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void myTest1() throws Exception {
		
		String mySQL = "INSERT INTO USERS(USERID, USERNAME, PASSWORD) VALUES(?, ?, ?)";
		
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement(mySQL);
		psmt.setNString(1, "blue");
		psmt.setNString(2, "blue");
		// USERPW : 암호화된 값을 넣어야 한다.
		// USERPW : 암호화된 값을 넣어야 한다.
		psmt.setNString(3, passwordEncoder.encode("blue")); 
		psmt.executeUpdate();
		
		psmt.close(); // 닫기
		conn.close(); // 닫기
		
		/*
		for(int i=1; i<=20; i++) {
			Connection conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement(mySQL);
			psmt.setNString(1, "test"+i);
			psmt.setNString(2, "test"+i);
			// USERPW : 암호화된 값을 넣어야 한다.
			// USERPW : 암호화된 값을 넣어야 한다.
			psmt.setNString(3, passwordEncoder.encode("test"+i)); 
			psmt.executeUpdate();
			
			psmt.close(); // 닫기
			conn.close(); // 닫기
		}
		*/
	}
	
	@Test
	public void myTest2() throws Exception {
		
		String mySQL = "INSERT INTO AUTHORITIES(USERID, AUTHORITY) VALUES(?, ?)";
		
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = conn.prepareStatement(mySQL);
		psmt.setNString(1, "blue");
		psmt.setNString(2, "ROLE_BLUE"); 
		psmt.executeUpdate();
		
		psmt.close(); // 닫기
		conn.close(); // 닫기
		
		/*
		for(int i=1; i<=20; i++) {
			Connection conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement(mySQL);
			psmt.setNString(1, "test"+i);
			psmt.setNString(2, "ROLE_BLUE"); 
			psmt.executeUpdate();
			
			psmt.close(); // 닫기
			conn.close(); // 닫기
		}
		*/
	}
	
}







