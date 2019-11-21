package first.actions.dao;

import org.springframework.stereotype.Repository;

import first.actions.model.UserInfo;
import first.common.dao.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {

	public UserInfo login(UserInfo info) throws Exception {
		return (UserInfo)selectOne("loginInfo.login", info);
	}
}
