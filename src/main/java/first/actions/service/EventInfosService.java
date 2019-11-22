package first.actions.service;

import java.util.List;
import java.util.Map;

import first.actions.model.EventInfos;

public interface EventInfosService {

	// 최근등록 이벤트 3건만 조회
	List<Map<String, EventInfos>> selectLatestEvents() throws Exception;

}
