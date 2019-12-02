package first.actions.service;

import java.util.List;
import java.util.Map;

import first.actions.model.ReviewInfos;

public interface ReviewInfosService {

	List<Map<String, Object>> selectLatestReviews() throws Exception;
	
	List<Map<String, Object>> reviewSearch(String ptnCd) throws Exception;
	
	String getMaxReviewSeq() throws Exception;
	
	int registEventInfos(ReviewInfos review) throws Exception;

}
