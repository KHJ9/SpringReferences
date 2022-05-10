package kr.or.ddit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.TestMapper;

@Service
public class SimpleServiceImpl implements SimpleService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public String select(String buyer_id) {
		// TODO Auto-generated method stub
		return "test";
	}

	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return testMapper.insertSimple();
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return testMapper.updateSimple();
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return testMapper.deleteSimple();
	}

}
