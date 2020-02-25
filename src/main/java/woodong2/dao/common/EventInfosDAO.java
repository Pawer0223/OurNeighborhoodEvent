package woodong2.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import woodong2.vo.common.EventInfos;
import woodong2.vo.common.Paging;

//EVENT_INFOS에 접근하는 DAO 클래스

@Repository("eventInfosDAO")
public class EventInfosDAO extends AbstractDAO {
	
	// 최근이벤트 3건만 조회 , 메인페이지 조회용도
	public List<Map<String, EventInfos>> selectLatestEvents() {
		return (List<Map<String, EventInfos>>)selectList("eventInfos.selectLatestEvents");
	}
	
	// 이벤트 리스트 조회
	public List<EventInfos> selectEventInfos(Paging paging) {
		return (List<EventInfos>)selectList("eventInfos.selectEventInfos",paging);
	}
	
	// 이벤트 총 갯수 조회
	public int getEventCount() {
		return (Integer)selectOne("eventInfos.getEventCount");
	}
	
	public EventInfos eventDetailInfo(String eventSeq) {
		return (EventInfos)selectOne("eventInfos.eventDetailInfo" , eventSeq);
	}
	
	public String getMaxEventSeq() {
		return (String)selectOne("eventInfos.getMaxEventSeq");
	}
	
	public int registEventInfos(EventInfos eventInfo) {
		return (Integer)insert("eventInfos.registEventInfos",eventInfo);
	}
	
	public String getPtnCd(String eventSeq) {
		return (String)selectOne("eventInfos.getPtnCd", eventSeq);
	}

}
