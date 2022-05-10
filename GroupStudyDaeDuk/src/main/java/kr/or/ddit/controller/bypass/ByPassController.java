package kr.or.ddit.controller.bypass;

import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * ByPass
 * 
 * @author  Kim Hyun Jun
 * @version 1.0
 * @see "프론트 단에서 비동기 방식으로 url요청을 할 때 CORS에러가 나는 것을 대비하여 url요청을 서버 단에서 대신 요청하도록 우회하는 방식에 대해 설명하고 있다."
 */
@Controller
@RequestMapping("/bypass")
public class ByPassController {

	@GetMapping("/bypass")
	public String getByPass() {
		return "bypass";
	}
	
	@GetMapping("/utubelist")
	public String getUtube() {
		return "utubelist";
	}
	
	// 서버 우회
	@GetMapping(value = "/googleXml", produces = "application/xml;charset=utf-8")
	@ResponseBody
	public Document getGoogleNews1(String st, int ln) throws Exception {
		String url = "https://news.google.com/rss/search?q="+st;
		if(ln == 1) url += "&hl=en-US&gl=US&ceid=US:en";
		if(ln == 2) url += "&hl=ko&gl=KR&ceid=KR:ko";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		//response.setHeader("Content-Type", "application/xml");
		
		Document doc = null;
		DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = docBuilder.newDocumentBuilder();
		
		// parsing to xml
		doc = builder.parse(response.getEntity().getContent());

		return doc;
	}
	
	// 서버 우회
	@GetMapping(value = "/googleXmlToJson", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getGoogleNews2(String st, int ln) throws Exception {
		String url = "https://news.google.com/rss/search?q="+st;
		if(ln == 1) url += "&hl=en-US&gl=US&ceid=US:en";
		if(ln == 2) url += "&hl=ko&gl=KR&ceid=KR:ko";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(getRequest);
		//response.setHeader("Content-Type", "application/xml");
		
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode node = xmlMapper.readTree(response.getEntity().getContent());
		

		ObjectMapper jsonMapper = new ObjectMapper();
		
		httpClient.close();
		return jsonMapper.writeValueAsString(node);  
			
	}
	
	// 서버 우회
	@GetMapping(value = "/googleJson", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getGoogleNews3() throws Exception {
		String url = "https://www.flickr.com/services/feeds/photos_public.gne?tags=blackpink&format=json";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url); // Get방식
		
		// 값 요청
		CloseableHttpResponse response = httpClient.execute(getRequest);
		
		// parsing to json
		String json = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
				
        httpClient.close();
        
        return json;
	}
	
	// 서버 우회
	@GetMapping(value = "/utubeList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getUtube(String schWord) throws Exception {
		String url = "https://www.youtube.com/results?search_query=";
		url += schWord;
		
		System.out.println(url);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url); // Get방식
		
		// 값 요청
		CloseableHttpResponse response = httpClient.execute(getRequest);
		
		// parsing to json
		String json = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
				
        httpClient.close();
        
        return json;
	}
	
	// 서버 우회
	@GetMapping(value = "/utube")
	@ResponseBody
	public String getUtubeList(String schCode) throws Exception {
		String url = "https://www.youtube.com/watch?v=";
		url += schCode;
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getRequest = new HttpGet(url); // Get방식
		
		// 값 요청
		CloseableHttpResponse response = httpClient.execute(getRequest);
		
		// parsing to json
		String json = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
				
        httpClient.close();
        
        return json;
	}
}
