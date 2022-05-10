package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Mapper;

// 인터페이스는 기본적인 설계도와 같다.
// 또한 구성 요소들을 하나의 추상화로서 정의하는 것.
// 이를 사용하면 이를 구현한 클래스들이 일관성있게 이루어질 수 있다.

// MyBatis가 다 알아서 JDBCUtil class형식으로 만들어준다.
@Mapper // 명시적으로 매퍼임을 표현해주는 게 좋음
public interface TestMapper {
	
	public String getBuyer(String buyer_id);
	
	public int insertSimple();
	
	public int updateSimple();
	
	public int deleteSimple();
	
}
