package first.actions.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.actions.model.ReviewInfos;
import first.common.dao.AbstractDAO;

//REVIEW_INFOS에 접근하는 DAO 클래스

@Repository("reviewInfosDAO")
public class ReviewInfosDAO extends AbstractDAO {
	
	
	// 최근리뷰 최대15건 조회 , 메인페이지 조회용도
	public List<Map<String, Object>> selectLatestReviews() {
		return (List<Map<String, Object>>)selectList("reviewInfos.selectLatestReviews");
	}
	
}
