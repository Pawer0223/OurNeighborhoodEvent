package woodong2.service.common.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woodong2.dao.common.UserInfosDAO;
import woodong2.service.common.UserInfosService;
import woodong2.vo.common.UserInfos;

@Service("userInfosService")
public class UserInfosServiceImpl implements UserInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="userInfosDAO")
	private UserInfosDAO userInfosDAO;

	@Override
	public int duplicateCheck(String inputId) throws Exception {
		return userInfosDAO.duplicateCheck(inputId);
	}

	@Override
	public int registUser(UserInfos userInfo) throws Exception {
		return userInfosDAO.registUser(userInfo);
	}

	@Override
	public UserInfos login(UserInfos userInfo) throws Exception {
		return userInfosDAO.login(userInfo);
	}

	@Override
	public int updatePtnCd(UserInfos userInfo) throws Exception {
		return userInfosDAO.updatePtnCd(userInfo);
	}
	
	

	
}
