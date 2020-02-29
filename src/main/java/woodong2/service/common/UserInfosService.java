package woodong2.service.common;

import woodong2.vo.common.UserInfos;

public interface UserInfosService {

	int duplicateCheck(String inputId) throws Exception;
	
	int registUser(UserInfos userInfo) throws Exception;
	
	UserInfos getUserInfo(String username) throws Exception;
	
	int updatePtnCd(UserInfos userInfo) throws Exception;

}
