package woodong2.service.common.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woodong2.dao.common.EventHistDAO;
import woodong2.service.common.EventHistService;

@Service("eventHistService")
public class EventHistServiceImpl implements EventHistService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="eventHistDAO")
	private EventHistDAO eventHistDAO;

	@Override
	public List<Map<String, Object>> participatedEvents(String userId) throws Exception {
		return eventHistDAO.participatedEvents(userId);
	}	
	
}
