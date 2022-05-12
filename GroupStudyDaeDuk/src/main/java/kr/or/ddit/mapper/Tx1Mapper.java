package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tx1Mapper {
	
	//@Insert("insert into tx1 values('${amuna}')")
	@Insert("insert into tx1 values(#{amuna})")
	public int insTx1(String amuna);
	
}
