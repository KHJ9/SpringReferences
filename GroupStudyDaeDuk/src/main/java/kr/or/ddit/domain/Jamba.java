package kr.or.ddit.domain;

import org.springframework.stereotype.Component;

@Component("jamba")
public class Jamba {
	
	public String color;
	
	public Jamba() {
		// TODO Auto-generated constructor stub
		this.color = "black";
		System.out.println("컴포넌트 안의 컴포넌트 자동 생성");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
