package kr.or.ddit.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class GilDong {

	private String nm_name;
	private String nm_special;
	private String nm_hobby;
	private List<MultipartFile> files;
	public String getNm_name() {
		return nm_name;
	}
	public void setNm_name(String nm_name) {
		this.nm_name = nm_name;
	}
	public String getNm_special() {
		return nm_special;
	}
	public void setNm_special(String nm_special) {
		this.nm_special = nm_special;
	}
	public String getNm_hobby() {
		return nm_hobby;
	}
	public void setNm_hobby(String nm_hobby) {
		this.nm_hobby = nm_hobby;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "GilDong [nm_name=" + nm_name + ", nm_special=" + nm_special + ", nm_hobby=" + nm_hobby + ", files="
				+ files + "]";
	}
	
}
