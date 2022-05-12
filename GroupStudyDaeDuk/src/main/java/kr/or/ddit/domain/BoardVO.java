package kr.or.ddit.domain;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component("board")
public class BoardVO {
	
	private String boardName;
	private String boardTitle;
	private String boardContent;
	private Date createDate;
	
	@PostConstruct // init-method에 해당 : 해당 객체가 생성될 시 호출될 메서드
	public void initStart() {
		System.out.println("Board Created! : " + toString());
	}
	
	@PreDestroy // destroy-method에 해당 : 해당 객체가 제거될 시 호출될 메서드
	public void destroyMethod() {
		System.out.println("Board Deleted! : " + toString());
	}
}
