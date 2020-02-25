package woodong2.service.common;

import java.util.List;
import java.util.Map;

public interface EventHistService {
	
	// 로그인 계정이 참여한 이벤트 리스트를 조회한다.
	List<Map<String,Object>> participatedEvents(String userId) throws Exception;
	

}
