package kr.or.ddit.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthVO {
	private String userid;
	private String auth;
}
