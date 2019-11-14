package first.loginAction.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.loginAction.dao.LoginDAO;
import first.loginAction.model.UserInfo;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return loginDAO.login(info);
	}
	
}
