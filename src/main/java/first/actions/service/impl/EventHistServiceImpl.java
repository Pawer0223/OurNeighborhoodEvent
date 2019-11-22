package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.EventHistDAO;
import first.actions.model.UserInfo;
import first.actions.service.EventHistService;

@Service("eventHistService")
public class EventHistServiceImpl implements EventHistService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="eventHistDAO")
	private EventHistDAO eventHistDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return null;
	}
	
}
