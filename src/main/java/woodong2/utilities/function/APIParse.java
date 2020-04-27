package woodong2.utilities.function;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import woodong2.vo.common.AddressInfo;
import woodong2.vo.common.PtnInfos;

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

		PtnInfos[] infos = new PtnInfos[1];

		if ( totalCount < 1 ) {
			log.info(" 조회결과 없음. ");
			PtnInfos info = new PtnInfos();
			info.setAddressNm("검색결과가 존재하지 않습니다.");
			infos[0]=info;
		}else {
			JSONArray documents = (JSONArray)jsonObject.get("documents");
			infos = new PtnInfos[documents.size()];

			for ( int i = 0 ; i < documents.size(); i ++ ) {
				JSONObject document = (JSONObject)documents.get(i);
				JSONObject roadAddress = (JSONObject)document.get("road_address");
				
				String addressNm = (String)roadAddress.get("address_name");
				String region1depthNm = (String)roadAddress.get("region_1depth_name");
				String region2depthNm = (String)roadAddress.get("region_2depth_name");
				String region3depthNm = (String)roadAddress.get("region_3depth_name");
				String roadNm = (String)roadAddress.get("region_3depth_name");
				String zoneNo = (String)roadAddress.get("zone_no");
				String longitude = (String)roadAddress.get("x"); //x가 경도 longitude
				String latitude = (String)roadAddress.get("y"); //y가 위도 latitude
				
				PtnInfos info = new PtnInfos(addressNm,zoneNo,latitude,longitude,region1depthNm,region2depthNm,region3depthNm,roadNm);

				infos[i] = info;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(infos);
	}

}
