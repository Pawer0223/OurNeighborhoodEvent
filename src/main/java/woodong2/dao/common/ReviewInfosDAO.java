package woodong2.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import woodong2.vo.common.ReviewInfos;

//REVIEW_INFOS에 접근하는 DAO 클래스

@Repository("reviewInfosDAO")
public class ReviewInfosDAO extends AbstractDAO {
	
	
	// 최근리뷰 최대15건 조회 , 메인페이지 조회용도
	public List<Map<String, Object>> selectLatestReviews() {
		return (List<Map<String, Object>>)selectList("reviewInfos.selectLatestReviews");
	}
	
	// 특정 eventSeq에 해당하는 review들을 조회한다.
	public List<Map<String, Object>> reviewSearch(String ptnCd) {
		return (List<Map<String, Object>>)selectList("reviewInfos.reviewSearch", ptnCd);
	}
	
	//maxSeq를 조회한다.
	public String getMaxReviewSeq() {
		return (String)selectOne("reviewInfos.getMaxReviewSeq");
	}
	
	public int registEventInfos(ReviewInfos review) {
		return (Integer)insert("reviewInfos.registReview",review);
	}
	
}
