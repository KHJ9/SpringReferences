package kr.or.ddit.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

// @Component("id명") // 해당 객체가 속할 id를 설정할 수 있다.

// context.xml에서 도메인 설정을 하지 않고도 component라는 
// 어노테이션을 작성하여 의존성 주입이 가능하도록 할 수 있다.
@Component("hyunjun2") // Spring MVC에서 제공해주는 어노테이션 Bean 생성
public class HyunJun2 implements ClassName405 {

	private String name;
	private int age;
	private Jamba jamba;
	
	public HyunJun2() {
		System.out.println("김현준");
	}
	
	public HyunJun2(Jamba jamba) {
		this.jamba = jamba;
		System.out.println("김현준");
	}
	
//	@PostConstruct // init-method에 해당 : 해당 객체가 생성될 시 호출될 메서드
	public void initStart() {
		System.out.println("김현준 : 이 클래스는 활성화 되었습니다.");
	}
	
//	@PreDestroy // destroy-method에 해당 : 해당 객체가 제거될 시 호출될 메서드
	public void destroyMethod() {
		System.out.println("김현준 : 이 클래스는 제거되었습니다.");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Jamba getJamba() {
		return jamba;
	}
	public void setJamba(Jamba jamba) {
		this.jamba = jamba;
	}
}
