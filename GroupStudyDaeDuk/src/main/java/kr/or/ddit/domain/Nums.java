package kr.or.ddit.domain;

public class Nums {
	
	private String nm_first;
	private String nm_second;
	private String nm_sel;
	
	public String getNm_first() {
		return nm_first;
	}
	public void setNm_first(String nm_first) {
		System.out.println("* nm_first : " + nm_first);
		this.nm_first = nm_first;
	}
	public String getNm_second() {
		return nm_second;
	}
	public void setNm_second(String nm_second) {
		System.out.println("* nm_second : " + nm_second);
		this.nm_second = nm_second;
	}
	public String getNm_sel() {
		return nm_sel;
	}
	public void setNm_sel(String nm_sel) {
		System.out.println("* nm_sel : " + nm_sel);
		this.nm_sel = nm_sel;
	}
	@Override
	public String toString() {
		return "Nums [nm_first=" + nm_first + ", nm_second=" + nm_second + ", nm_sel=" + nm_sel + "]";
	}
}
