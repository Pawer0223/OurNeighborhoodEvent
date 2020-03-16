package woodong2.service.common;

import woodong2.vo.common.PtnInfos;

public interface PtnInfosService {

	/**
	 * 
	 * 
	 * @param ptninfo : 파트너정보 등록하기 위함.
	 * @param userId : 파트너정보등록시 ROLE_PARTNER추가하기위함.
	 * @return
	 * @throws Exception
	 */
	int registPtnInfos(PtnInfos ptninfo, String userId) throws Exception;
	
	String getMaxPtnCd() throws Exception;
	
	PtnInfos getPtnInfo(String ptnCd) throws Exception;

}
