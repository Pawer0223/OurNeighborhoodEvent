package first.actions.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.EventInfosDAO;
import first.actions.model.EventInfos;
import first.actions.service.EventInfosService;

@Service("eventInfosService")
public class EventInfosServiceImpl implements EventInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="eventInfosDAO")
	private EventInfosDAO eventInfosDAO;

	@Override
	public List<Map<String, EventInfos>> selectLatestEvents() throws Exception {
		return eventInfosDAO.selectLatestEvents();
	}

	@Override
	public EventInfos eventDetailInfo(String eventSeq) throws Exception {
		return eventInfosDAO.eventDetailInfo(eventSeq);
	}

}
