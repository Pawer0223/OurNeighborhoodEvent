package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.EventInfosDAO;
import first.actions.service.EventInfosService;
import first.loginAction.model.UserInfo;

@Service("eventInfosService")
public class EventInfosServiceImpl implements EventInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="eventInfosDAO")
	private EventInfosDAO eventInfosDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return null;
	}
	
}
