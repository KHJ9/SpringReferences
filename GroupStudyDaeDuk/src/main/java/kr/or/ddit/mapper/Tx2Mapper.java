package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Tx2Mapper {
	
	//@Insert("insert into tx2 values('${amuna}')")
	@Insert("insert into tx2 values(#{amuna})")
	public int insTx2(String amuna);
	
}
