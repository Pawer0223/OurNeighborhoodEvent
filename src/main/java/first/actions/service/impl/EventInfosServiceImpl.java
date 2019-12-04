package first.actions.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.EventInfosDAO;
import first.actions.model.EventInfos;
import first.actions.model.Paging;
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

	@Override
	public String getMaxEventSeq() throws Exception {
		return eventInfosDAO.getMaxEventSeq();
	}

	@Override
	public int registEventInfos(EventInfos eventInfo) throws Exception {
		return eventInfosDAO.registEventInfos(eventInfo);
	}

	@Override
	public String getPtnCd(String eventSeq) throws Exception {
		return eventInfosDAO.getPtnCd(eventSeq);
	}

	@Override
	public List<EventInfos> selectEventInfos(Paging paging) throws Exception {
		return eventInfosDAO.selectEventInfos(paging);
	}

	@Override
	public int getEventCount() throws Exception {
		return eventInfosDAO.getEventCount();
	}

}
