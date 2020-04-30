package woodong2.service.common.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import woodong2.dao.common.PtnInfosDAO;
import woodong2.dao.common.UserInfosDAO;
import woodong2.service.common.PtnInfosService;
import woodong2.vo.common.Authority;
import woodong2.vo.common.PtnInfos;

@Service("ptnInfosService")
public class PtnInfosServiceImpl implements PtnInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="ptnInfosDAO")
	private PtnInfosDAO ptnInfosDAO;
	
	/*
	 * 파트너정보 등록시 Authorize테이블에 권한 추가하기 위함.
	 */
	@Resource(name="userInfosDAO")
	private UserInfosDAO userInfosDAO;
	
	@Override
	@Transactional
	public int registPtnInfos(PtnInfos ptninfo, String userId) throws Exception {
		
		int result = 0;
		result = ptnInfosDAO.registPtnInfos(ptninfo);
		
		if ( result != 0 )
			userInfosDAO.insertAuthority(new Authority(userId, "ROLE_PARTNER"));
		
		return result; 
	}

	@Override
	public String getMaxPtnCd() throws Exception {
		return ptnInfosDAO.getMaxPtnCd();
	}

	@Override
	public PtnInfos getPtnInfo(String ptnCd) throws Exception {
		return ptnInfosDAO.getPtnInfo(ptnCd);
	}

	@Override
	public int bizrNoDuplicateCheck(String bizrRegNo) {
		return ptnInfosDAO.bizrNoDuplicateCheck(bizrRegNo);
	}

	@Override
	public JsonArray getNearEvents(PtnInfos ptnInfo) {
		List<Map<String,Object>> nearEvents = ptnInfosDAO.getNearEvents(ptnInfo);
		
		// JSON 객체를 JSONArray로 바꿔준다.
		JsonParser parser = new JsonParser();

		// 받아온 List타입의 데이터를 JSON 객체로 변환을해야 parser기능을 사용할 수 있다.
		Gson gson = new Gson();
		JsonArray jsonArray = (JsonArray)parser.parse(gson.toJson(nearEvents));
		
		return jsonArray;
		
	}
	
}
