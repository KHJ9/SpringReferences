package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.domain.MemberVO;

@Mapper
public interface MemberMapper {

	public MemberVO read(String userId);
	
}
