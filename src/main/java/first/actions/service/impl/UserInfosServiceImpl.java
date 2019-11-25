package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.UserInfosDAO;
import first.actions.model.UserInfos;
import first.actions.service.UserInfosService;
import first.loginAction.model.UserInfo;

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
		// TODO Auto-generated method stub
		return userInfosDAO.login(userInfo);
	}
	
	

	
}
