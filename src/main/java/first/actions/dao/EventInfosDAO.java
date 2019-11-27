package first.actions.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.actions.model.EventInfos;
import first.common.dao.AbstractDAO;

//EVENT_INFOS에 접근하는 DAO 클래스

@Repository("eventInfosDAO")
public class EventInfosDAO extends AbstractDAO {
	
	// 최근이벤트 3건만 조회 , 메인페이지 조회용도
	public List<Map<String, EventInfos>> selectLatestEvents() {
		return (List<Map<String, EventInfos>>)selectList("eventInfos.selectLatestEvents");
	}
	
	public EventInfos eventDetailInfo(String ptnCd) {
		return (EventInfos)selectOne("eventInfos.eventDetailInfo" , ptnCd);
	}

}
