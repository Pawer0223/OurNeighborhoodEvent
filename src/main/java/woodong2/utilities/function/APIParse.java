package woodong2.utilities.function;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import woodong2.vo.common.AddressInfo;

public class APIParse {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public String jusosParse(String data) {

		String[] jusos = new String[1];

		JSONObject jsonObject = new JSONObject();
		JSONParser parser = new JSONParser();

		try {
			jsonObject = (JSONObject)parser.parse(data);
		}catch(Exception e) {
			log.info(" jusosParse 수행 시 Error 발생 !! ");
			e.printStackTrace();
		}

		JSONObject results = (JSONObject)jsonObject.get("results");

		// 응답정보
		JSONObject common = (JSONObject)results.get("common");

		int totalCount= Integer.valueOf((String)common.get("totalCount"));

		log.info(" totalCount : " + totalCount );

		if ( totalCount < 1 ) {
			log.info(" 조회결과 없음. ");
			jusos[0] = "검색결과가 존재하지 않습니다.";
		}else {
			JSONArray juso = (JSONArray)results.get("juso");
			jusos = new String[juso.size()];

			for ( int i = 0 ; i < juso.size(); i ++ ) {
				JSONObject address = (JSONObject)juso.get(i);
				String roadAddr = (String)address.get("roadAddr");
				jusos[i] = roadAddr;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(jusos);
	}

	public String kakaoLocalParse(String data) {

		JSONObject jsonObject = new JSONObject();
		JSONParser parser = new JSONParser();

		try {
			jsonObject = (JSONObject)parser.parse(data.toString());
		}catch(Exception e) {
			log.info(" kakaoLocalParse 수행 시 Error 발생 !! ");
			e.printStackTrace();
		}

		JSONObject meta = (JSONObject)jsonObject.get("meta");
		long totalCount= (long)meta.get("total_count");

		log.info(" KaKao totalCount : " + totalCount );

		AddressInfo[] infos = new AddressInfo[1];

		if ( totalCount < 1 ) {
			log.info(" 조회결과 없음. ");
			AddressInfo info = new AddressInfo("0","0","검색결과가 존재하지 않습니다.");
			infos[0]=info;
		}else {
			JSONArray documents = (JSONArray)jsonObject.get("documents");
			infos = new AddressInfo[documents.size()];

			for ( int i = 0 ; i < documents.size(); i ++ ) {
				JSONObject address = (JSONObject)documents.get(i);

				String addressNm = (String)address.get("address_name");
				String x = (String)address.get("x");
				String y = (String)address.get("y");

				AddressInfo info = new AddressInfo(x,y,addressNm);

				infos[i] = info;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(infos);
	}

}
