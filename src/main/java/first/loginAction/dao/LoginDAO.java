package first.loginAction.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;
import first.loginAction.model.UserInfo;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {

	public UserInfo login(UserInfo info) throws Exception {
		return (UserInfo)selectOne("loginInfo.login", info);
	}
}
