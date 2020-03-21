package woodong2.controller.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	private final String SERVICE_KEY = "U01TX0FVVEgyMDIwMDMyMTE1MTgwMDEwOTU2NjE=";

	@RequestMapping(value="/sample/getAddrApi.do")
	public String getAddrApi(HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
		
		String stringUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do";
		StringBuilder urlBuilder = new StringBuilder(stringUrl); /*URL*/

		int currentPage= 1;
		int countPerPage= 10;
		String keyword = req.getParameter("keyword");            //요청 변수 설정 (키워드)
		
		String resultType= "json";

		
		urlBuilder.append("?currentPage=" + currentPage ); /* 페이지 */
		urlBuilder.append("&countPerPage=" + countPerPage ); /* 건수 */
		urlBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8")); /* 검색주소 */
		urlBuilder.append("&confmKey=" + SERVICE_KEY ); /* 발급받은 key */
		urlBuilder.append("&resultType=" + resultType ); /* 없으면 XML */
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		System.out.println(sb.toString());

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().write(sb.toString());			// 응답결과 반환

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

				req.setAttribute("jusos", jusos);
			}
		}

		return "/test/searchTest";
	}
}
