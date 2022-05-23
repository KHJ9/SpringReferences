package kr.or.ddit.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	
	private int RowNum;
	private String tableName;
	private String pkName;
	private int curPageNum;
	private int totPageNum;
	private String searchText;
	private String pkNum;

}
