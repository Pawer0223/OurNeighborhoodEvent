package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.MenuListDAO;
import first.actions.service.MenuListService;
import first.loginAction.model.UserInfo;

@Service("menuListService")
public class MenuListServiceImpl implements MenuListService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="menuListDAO")
	private MenuListDAO menuLisDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return null;
	}
	
}
