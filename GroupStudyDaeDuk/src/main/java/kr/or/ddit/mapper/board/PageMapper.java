package kr.or.ddit.mapper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.domain.PageDTO;

@Mapper
public interface PageMapper {

	public List<PageDTO> select(PageDTO page);
	
}
