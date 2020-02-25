package woodong2.service.common;

import java.util.List;
import java.util.Map;

import woodong2.vo.common.ReviewInfos;

public interface ReviewInfosService {

	List<Map<String, Object>> selectLatestReviews() throws Exception;
	
	List<Map<String, Object>> reviewSearch(String ptnCd) throws Exception;
	
	String getMaxReviewSeq() throws Exception;
	
	int registEventInfos(ReviewInfos review) throws Exception;

}
