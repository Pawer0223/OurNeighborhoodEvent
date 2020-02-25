package woodong2.service.common;

import java.util.List;
import java.util.Map;

import woodong2.vo.common.EventInfos;
import woodong2.vo.common.Paging;


public interface EventInfosService {

	// 최근등록 이벤트 3건만 조회
	List<Map<String, EventInfos>> selectLatestEvents() throws Exception;
	
	// 원하는 만큼 데이터 조회
	List<EventInfos> selectEventInfos(Paging paging) throws Exception;
	
	// 이벤트 총 건수 조회
	int getEventCount() throws Exception;
	
	EventInfos eventDetailInfo(String eventSeq) throws Exception;
	
	String getMaxEventSeq() throws Exception;
	
	int registEventInfos(EventInfos eventInfo) throws Exception;
	
	String getPtnCd(String eventSeq) throws Exception;
	
	
	

}
