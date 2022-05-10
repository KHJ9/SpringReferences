package kr.or.ddit.controller.fileUpload;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * CkUploadController
 * CKUpload에디터 오픈소스를 활용하여 내용란에 이미지를 올릴 시
 * 서버 단에서 이를 처리하도록 하는 곳이다.
 * 
 * @author  Kim Hyun Jun
 * @version 1.0
 */
@Controller
@Slf4j
public class CkUploadController {
	
	@PostMapping(value="/ckUpload", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String ckUpload(HttpServletRequest req,
			             HttpServletResponse res,
			             MultipartFile upload) throws Exception {
		
		
		// mklink /D 명령을 이용하여 바로가기로 만들어준다.
		// 그러면 실제 파일이 저장되는 경로와 이클립스가 임시로 저장하는 경로가  서로 연결된다.
		
		// 이클립스가 실제로 사용하는 디렉토리
		String realPath = req.getServletContext().getRealPath("/resources/ckUpload").replace("\\",  "/");
		
		System.out.println(realPath);
		
		//log.info("webapp/resources" + req.getServletContext().getRealPath("/resources"));
		//log.info("webapp/WEB-INF" + req.getServletContext().getRealPath("/resources/WEB-INF"));
		
		//log.info(upload.getOriginalFilename());
		
		// 파일 이름 충돌나지 않게 하기 위한 랜덤 문자열 생성
		UUID uid = UUID.randomUUID();
				
		String fileName = upload.getOriginalFilename();
		//log.info("fileName===>"+fileName);
		// uploadPath : servlet-context.xml에 bean으로 지정한 문자열
		// bean에 저장된 문자열의 경로가 입력된다.
		// String ckUploadPath = uploadPath + uid + "_" + fileName;
		String ckUploadPath = realPath + "/" + uid + "_" + fileName;
		//log.info("ckUploadPath===>"+ckUploadPath);
		
		System.out.println(ckUploadPath);
		
		// 비동기
		upload.transferTo(new File(ckUploadPath)); // 파일 업로드
		
		// 이미지 업로드 + 이클립스 버퍼링 때문에
		// 이미지 미리보기 기능이 원활하게 돌아가지 않는 문제가 있다.
		
	    // ck에디터에 값을 넘겨주기 위한 준비과정이 필요함
		String callback = req.getParameter("CKEditorFuncNum");
		//log.info("callback===>"+callback);
		//String fileUrl = req.getContextPath() + "/ckUpload/" + uid + "_" + fileName;
		
		// 실제 이클립스가 파일을 먼저 Upload하는 폴더
		String fileUrl = req.getContextPath() + "/ckUpload/" + uid + "_" + fileName;
		//log.info("fileUrl===>"+fileUrl);
        /* CKEditor가 원하는 스크립트 문자열을 리턴(아님말공)  */
		String scriptStr = "<script type='text/javascript'>"
				+ "window.parent.CKEDITOR.tools.callFunction("
				+ callback + ",'" + fileUrl+"','이미지 업')"
				+ "</script>";
	
		return scriptStr;
		
	}
	
	@GetMapping(value="/uploadCheck")
	public String uploadCheck(HttpServletRequest request) throws Exception {
		log.info("필터에서 받아온 데이터 : " + request.getAttribute("dummy"));
		return "uploadCheck";
	}
	
	// 한글 인코딩을 위해 다음과 같이 Mapping내용을 작성할 것을 권장
	@PostMapping(value="/gUpload", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Map<String, String>> gUpload(HttpServletRequest req,
			             HttpServletResponse res,
			             MultipartFile p_file) throws Exception {
		
		String realPath = req.getServletContext().getRealPath("/resources/ckUpload").replace("\\",  "/");

		UUID uid = UUID.randomUUID();
				
		String fileName = p_file.getOriginalFilename();
		String ckUploadPath = realPath + "/" + uid + "_" + fileName;
		p_file.transferTo(new File(ckUploadPath)); // 파일 업로드
		
		String fileUrl = req.getContextPath() + "/ckUpload/" + uid + "_" + fileName;
		log.info("fileUrl ===> " + fileUrl);
		
		Map<String, Map<String, String>> responseData = new HashMap<String, Map<String, String>>();
		Map<String, String> dataList = new HashMap<String, String>();
		dataList.put("fileName", fileName);
		dataList.put("fileUrl", fileUrl);
		
		// 잭슨 라이브러리를 참조한 경우에만 콜렉션을 json으로 '자동변환'하여 반환할 수 있다.
		responseData.put("data", dataList);
		return responseData;
		
	}
}