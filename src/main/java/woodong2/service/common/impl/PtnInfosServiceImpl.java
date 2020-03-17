package woodong2.service.common.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
	
}
