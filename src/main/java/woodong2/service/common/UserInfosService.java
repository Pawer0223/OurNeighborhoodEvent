package woodong2.service.common;

import woodong2.vo.common.UserInfos;

public interface UserInfosService {

	/**
	 * id 중복체크
	 * @param inputId
	 * @return
	 * @throws Exception
	 */
	int duplicateCheck(String inputId) throws Exception;
	
	/**
	 * 계정등록, 권한도 함께등록함
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	int registUser(UserInfos userInfo) throws Exception;
	/**
	 * 
	 * 계정정보 조회
	 * @param username
	 * @return
	 * @throws Exception
	 */
	UserInfos getUserInfo(String username) throws Exception;
	/**
	 * 파트너 코드등록
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	int updatePtnCd(UserInfos userInfo) throws Exception;

}
