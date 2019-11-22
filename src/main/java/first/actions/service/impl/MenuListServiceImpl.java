package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.MenuListDAO;
import first.actions.model.UserInfo;
import first.actions.service.MenuListService;

@Service("menuListService")
public class MenuListServiceImpl implements MenuListService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="menuLisDAO")
	private MenuListDAO menuLisDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return null;
	}
	
}
