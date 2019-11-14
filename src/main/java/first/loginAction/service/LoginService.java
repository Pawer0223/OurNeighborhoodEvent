package first.loginAction.service;

import java.util.List;
import java.util.Map;

import first.loginAction.model.UserInfo;

public interface LoginService {

	UserInfo login(UserInfo info) throws Exception;

}
