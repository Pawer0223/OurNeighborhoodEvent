package first.actions.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.ReviewInfosDAO;
import first.actions.model.ReviewInfos;
import first.actions.service.ReviewInfosService;

@Service("reviewInfosService")
public class ReviewInfosServiceImpl implements ReviewInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="reviewInfosDAO")
	private ReviewInfosDAO reviewInfosDAO;

	@Override
	public List<Map<String, Object>> selectLatestReviews() throws Exception {
		return reviewInfosDAO.selectLatestReviews();
	}

	@Override
	public List<Map<String, Object>> reviewSearch(String ptnCd) throws Exception {
		return reviewInfosDAO.reviewSearch(ptnCd);
	}

	@Override
	public String getMaxReviewSeq() throws Exception {
		return reviewInfosDAO.getMaxReviewSeq();
	}

	@Override
	public int registEventInfos(ReviewInfos review) throws Exception {
		return reviewInfosDAO.registEventInfos(review);
	}
	
}
