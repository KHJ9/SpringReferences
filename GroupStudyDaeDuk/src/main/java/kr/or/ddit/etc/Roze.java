package kr.or.ddit.etc;

// 어댑터 패턴 : 인터페이스를 구현한 빈 클래스를 상속받아 필요한 메서드만 오버라이딩하도록 할 수 있다.
// 
public class Roze extends BlackPinkAdapter {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AdapterPatternExample";
	}
	
}
