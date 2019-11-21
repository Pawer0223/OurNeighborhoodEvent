package first.loginAction.service;

import first.actions.model.UserInfo;

public interface LoginService {

	UserInfo login(UserInfo info) throws Exception;

}
