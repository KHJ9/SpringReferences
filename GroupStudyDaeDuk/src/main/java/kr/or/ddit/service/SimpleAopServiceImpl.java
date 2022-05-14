package kr.or.ddit.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimpleAopServiceImpl implements SimpleAopService {

	@Override
	public Integer add(String str1, String str2) {
		// TODO Auto-generated method stub
		log.info("난 ADD (ServiceImpl)");
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}
	
	@Override
	public Integer minus(String str1, String str2) {
		// TODO Auto-generated method stub
		log.info("난 MINUS (ServiceImpl)");
		return Integer.parseInt(str1) - Integer.parseInt(str2);
	}
	
}
