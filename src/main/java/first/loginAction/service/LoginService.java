package first.loginAction.service;

import first.loginAction.model.UserInfo;

public interface LoginService {

	UserInfo login(UserInfo info) throws Exception;

}
