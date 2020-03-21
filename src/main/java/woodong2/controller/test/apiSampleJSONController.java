package woodong2.controller.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import woodong2.vo.common.Juso;


@Controller
public class apiSampleJSONController {
	
    @RequestMapping(value="/sample/getAddrApi.do")
    public void getAddrApi(HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
		// 요청변수 설정
    String currentPage = req.getParameter("currentPage");    //요청 변수 설정 (현재 페이지. currentPage : n > 0)
		String countPerPage = req.getParameter("countPerPage");  //요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100)
		String resultType = req.getParameter("resultType");      //요청 변수 설정 (검색결과형식 설정, json)
		String confmKey = req.getParameter("confmKey");          //요청 변수 설정 (승인키)
		String keyword = req.getParameter("keyword");            //요청 변수 설정 (키워드)
		// OPEN API 호출 URL 정보 설정
		String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey+"&resultType="+resultType;
		URL url = new URL(apiUrl);
    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
    	StringBuffer sb = new StringBuffer();
    	String tempStr = null;

    	while(true){
    		tempStr = br.readLine();
    		if(tempStr == null) break;
    		sb.append(tempStr);								// 응답결과 JSON 저장
    	}
    	
    	br.close();
    	
    	// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/xml");
		// response.getWriter().write(sb.toString());			// 응답결과 반환
		
		System.out.println(" 여기타는지 일단보자구 ");
		
		JSONObject jsonObject = new JSONObject();
        
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject)parser.parse(sb.toString());
		
		JSONObject results = (JSONObject)jsonObject.get("results");
		
		// 응답정보
		JSONObject common = (JSONObject)results.get("common");
		
		int totalCount= Integer.valueOf((String)common.get("totalCount"));
		
		System.out.println(" totalCount : " + totalCount );
		
		if ( totalCount < 1 ) {
			System.out.println(" 조회결과 없음. ");
		}else {
			
			JSONArray juso = (JSONArray)results.get("juso");
			
			List<Juso> jusos = new ArrayList<Juso>();
			
			for ( int i = 0 ; i < juso.size(); i ++ ) {
				
				JSONObject address = (JSONObject)juso.get(i);
				
				String detBdNmList    = (String)address.get("detBdNmList");
				String engAddr 		  = (String)address.get("engAddr");
				String rn  			  = (String)address.get("rn");
				String emdNm 		  = (String)address.get("emdNm");
				String zipNo  		  = (String)address.get("zipNo");
				String roadAddrPart2  = (String)address.get("roadAddrPart2");
				String emdNo  		  = (String)address.get("emdNo");
				String sggNm  		  = (String)address.get("sggNm");
				String jibunAddr  	  = (String)address.get("jibunAddr");
				String siNm  		  = (String)address.get("siNm");
				String roadAddrPart1  = (String)address.get("roadAddrPart1");
				String bdNm  		  = (String)address.get("bdNm");
				String admCd  		  = (String)address.get("admCd");
				String udrtYn 	 	  = (String)address.get("udrtYn");
				String lnbrMnnm  	  = (String)address.get("lnbrMnnm");
				String roadAddr  	  = (String)address.get("roadAddr");
				String lnbrSlno  	  = (String)address.get("lnbrSlno");
				String buldMnnm  	  = (String)address.get("buldMnnm");
				String bdKdcd  		  = (String)address.get("bdKdcd");
				String liNm  		  = (String)address.get("liNm");
				String rnMgtSn  	  = (String)address.get("rnMgtSn");
				String mtYn  		  = (String)address.get("mtYn");
				String bdMgtSn  	  = (String)address.get("bdMgtSn");
				String buldSlno  	  = (String)address.get("buldSlno");

				Juso j = new Juso(detBdNmList ,engAddr ,rn ,emdNm ,zipNo ,roadAddrPart2 ,emdNo ,sggNm ,jibunAddr ,siNm ,roadAddrPart1 ,bdNm ,admCd ,udrtYn ,lnbrMnnm ,roadAddr ,lnbrSlno ,buldMnnm ,bdKdcd ,liNm ,rnMgtSn ,mtYn ,bdMgtSn ,buldSlno);
				jusos.add(j);
				
				System.out.println( i + "번째 Value : " + j.toString() ) ;
				
			}
		}
		
		
		
		
		
		
		
		
		
    }
}
