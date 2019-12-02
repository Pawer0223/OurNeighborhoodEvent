package first.actions.service;

import first.actions.model.UserInfos;

public interface UserInfosService {

	int duplicateCheck(String inputId) throws Exception;
	
	int registUser(UserInfos userInfo) throws Exception;
	
	UserInfos login(UserInfos userInfo) throws Exception;
	
	int updatePtnCd(UserInfos userInfo) throws Exception;

}
