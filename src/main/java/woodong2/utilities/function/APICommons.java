package woodong2.utilities.function;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class APICommons {
	
	// 주소검색 API , 도로명주소 사이트  SERVICE_KEY
	private final String JUSOS_KEY =  "U01TX0FVVEgyMDIwMDMyMTE1MTgwMDEwOTU2NjE=";
	
	// KAKAO LOCAL 검색 KEY
	private final String KAKAO_LOCAL_KEY =  "87a1c0ac6fa481c008c408c7b819d530";
	
	// 도로명주소 사이트 URL
	private final String JUSOS_URL = "http://www.juso.go.kr/addrlink/addrLinkApi.do";
	
	// KAKAO LOCAL 검색 URL
	private final String KAKAO_LOCAL_URL = "https://dapi.kakao.com/v2/local/search/address.json";
	
	
	public StringBuilder callAPI(Map<String,Object> params, String apiNm) throws Exception {
		
		StringBuilder urlBuilder = makeUrl(params,apiNm);
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		if(apiNm.equals("Jusos")) {
			conn.setRequestProperty("Content-type", "application/json");
		}else if(apiNm.equals("KaKao_Local")) {
			String auth = "KakaoAK " + KAKAO_LOCAL_KEY;
			conn.setRequestProperty("User-Agent", "Java-Client");	// https 호출시 user-agent 필요
			conn.setRequestProperty("X-Requested-With", "curl");
			conn.setRequestProperty("Authorization", auth);
		}
		
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;

		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		return sb;
	}
	
	private StringBuilder makeUrl(Map<String,Object> params, String apiNm) {
		
		StringBuilder urlBuilder = new StringBuilder(); /*URL*/
		String key = "";
		
		if( apiNm.equals("Jusos")) {
			urlBuilder = new StringBuilder(JUSOS_URL); /*URL*/
			key = JUSOS_KEY;
		}else if( apiNm.equals("KaKao_Local")) { // kakao local api는 header에 key값이 붙는다.
			urlBuilder = new StringBuilder(KAKAO_LOCAL_URL); /*URL*/
		}
		
		Iterator keys = params.keySet().iterator();
		
		int index = 0 ;
		
		while(keys.hasNext()) {
			
			if(index==0) urlBuilder.append("?");
			else urlBuilder.append("&");
			
			 String paramKey = (String)keys.next();
			 
			 if(paramKey.contains("(INT)")) {
				 int intValue = (int)params.get(paramKey);
				 urlBuilder.append(paramKey+"="+intValue);
			 }else { // String
				 String strValue = (String)params.get(paramKey);
				 if(strValue.equals("MAIN_KEY")) strValue = key;
				 urlBuilder.append(paramKey+"="+strValue);
			 }
			 index++;
		}
		return urlBuilder;
	}
	

}
