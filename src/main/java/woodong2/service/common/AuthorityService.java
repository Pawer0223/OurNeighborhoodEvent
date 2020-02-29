package woodong2.service.common;

import java.util.List;

public interface AuthorityService {
	
	// 권한리스트 조회
	public List<String> getAuthorities(String username) throws Exception;
	
}
