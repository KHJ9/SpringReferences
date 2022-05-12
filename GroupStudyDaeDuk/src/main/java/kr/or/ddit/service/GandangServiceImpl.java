package kr.or.ddit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.mapper.Tx1Mapper;
import kr.or.ddit.mapper.Tx2Mapper;

@Service
public class GandangServiceImpl implements GandangService {
	
	@Autowired
	private Tx1Mapper tx1Mapper;
	
	@Autowired
	private Tx2Mapper tx2Mapper;
	
	@Override
	// isolation
	@Transactional(isolation = Isolation.DEFAULT, 
	propagation = Propagation.REQUIRED, readOnly = true) // 트랜잭션 기능을 위한 어노테이션
	public void ins2tb() {
		// insTx2는 오류가 안 나고 insTx1는 컬럼 크기가 작은 관계로 오류가 날 것이다.
		// 이 때 스프링에서 설정해 둔 트랜잭션으로 테이블의 상태를 이전 단계로 되돌릴 수 있다.
		tx2Mapper.insTx2("Today is Thursday, Tomorrow is Friday.");
		//tx1Mapper.insTx1("Today is Thursday, Tomorrow is Friday.");
	}
}
