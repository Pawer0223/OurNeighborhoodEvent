package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.UserInfosDAO;
import first.actions.model.UserInfo;
import first.actions.service.UserInfosService;

@Service("userInfosService")
public class UserInfosServiceImpl implements UserInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="userInfosDAO")
	private UserInfosDAO userInfosDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return null;
	}
	
}
