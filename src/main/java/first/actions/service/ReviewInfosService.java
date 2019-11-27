package first.actions.service;

import java.util.List;
import java.util.Map;

import first.actions.model.ReviewInfos;

public interface ReviewInfosService {

	List<Map<String, Object>> selectLatestReviews() throws Exception;
	
	List<Map<String, Object>> reviewSearch(String eventSeq) throws Exception;

}
