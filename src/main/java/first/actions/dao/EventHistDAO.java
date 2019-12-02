package first.actions.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

//EVENT_HIST에 접근하는 DAO 클래스

@Repository("eventHistDAO")
public class EventHistDAO extends AbstractDAO{
	
	// 최근이벤트 3건만 조회 , 메인페이지 조회용도
	public List<Map<String, Object>> participatedEvents(String userId) {
		return (List<Map<String, Object>>)selectList("eventHist.participatedEvents",userId);
	}

}
