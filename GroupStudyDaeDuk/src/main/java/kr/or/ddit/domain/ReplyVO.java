package kr.or.ddit.domain;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component("reply")
public class ReplyVO {
	
	private String replyNum;
	private String boardNum;
	private String replyWriter;
	private String replyContent;
	private Date createDate;
	private Date updateDate;
	
	//@PostConstruct // init-method에 해당 : 해당 객체가 생성될 시 호출될 메서드
	public void initStart() {
		System.out.println("Reply Created! : " + toString());
	}
	
	//@PreDestroy // destroy-method에 해당 : 해당 객체가 제거될 시 호출될 메서드
	public void destroyMethod() {
		System.out.println("Reply Deleted! : " + toString());
	}
}
