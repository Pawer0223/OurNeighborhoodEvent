package woodong2.utilities.function;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import woodong2.vo.common.Juso;

public class ApiTestFunctions {
	
	private static Logger log = LoggerFactory.getLogger("ApiTestFunctions");
	
	private static String SERVICE_KEY = "U01TX0FVVEgyMDIwMDMyMTE1MTgwMDEwOTU2NjE=";

	public static void main(String[] args) throws Exception {
		apiCall();
	}

	private static void apiCall() throws Exception{
		
		System.out.println(" woodong2 ");

		String stringUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do";
		StringBuilder urlBuilder = new StringBuilder(stringUrl); /*URL*/

		int currentPage= 1;
		int countPerPage= 10;
		String keyword= "구성로 184"; //용인시 기흥구 
		String resultType= "json";
		
		
		urlBuilder.append("?currentPage=" + currentPage ); /* 페이지 */
		urlBuilder.append("&countPerPage=" + countPerPage ); /* 건수 */
		urlBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8")); /* 검색주소 */
		urlBuilder.append("&confmKey=" + SERVICE_KEY ); /* 발급받은 key */
		urlBuilder.append("&resultType=" + resultType ); /* 없으면 XML */

		System.out.println(urlBuilder.toString());

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
		
		
		
		
		

	}

}
