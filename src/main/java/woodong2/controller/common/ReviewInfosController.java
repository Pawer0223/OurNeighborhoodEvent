package woodong2.controller.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventHistService;
import woodong2.service.common.EventInfosService;
import woodong2.service.common.ReviewInfosService;
import woodong2.vo.common.ReviewInfos;
import woodong2.vo.common.UserInfos;

@Controller
public class ReviewInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;
	
	@Resource(name = "eventHistService")
	private EventHistService eventHistService;
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	

	@RequestMapping(value = "/reviewInfos/registReviewPage.do")
	public ModelAndView registReviewPage(HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView("/main/index");
		
		// 로그인 계정이 참여한 이벤트 정보를 먼저 조회한다.
		HttpSession session = request.getSession();
		
		UserInfos loginInfo = (UserInfos)session.getAttribute("login");
		
		List<Map<String,Object>> partEvents = eventHistService.participatedEvents(loginInfo.getUserId());
		
		// 없으면 이벤트 alert창 출력
		if ( partEvents == null || partEvents.isEmpty() ) {
			session.setAttribute("messageType", "noSearchEvents");
			return mv;
		}else {
			mv = new ModelAndView("/main/registForm/registReview");
			mv.addObject("participatedEvents" , partEvents );
			return mv;
		}
	}
	
	@RequestMapping(value = "/reviewInfos/registReviews.do")
	public ModelAndView registReviews(ReviewInfos review, HttpServletRequest request) throws Exception {
		
		 System.out.println(review.toString());
		
		ModelAndView mv = new ModelAndView("/main/registForm/registReview");
		
		// 로그인 계정이 참여한 이벤트 정보를 먼저 조회한다.
		HttpSession session = request.getSession();
		
		UserInfos loginInfo = (UserInfos)session.getAttribute("login");
		
		// 리뷰등록 id
		review.setUserId(loginInfo.getUserId());
		
		//이벤트 seq로  ptnCd 조회 
		String ptnCd = eventInfosService.getPtnCd(review.getEventSeq());
		review.setPtnCd(ptnCd);
		
		//maxSeq 조회
		String maxReviewSeq = reviewInfosService.getMaxReviewSeq();
		review.setReviewSeq(maxReviewSeq);
			
		// 성공시1, 실패시0반환
		if( reviewInfosService.registEventInfos(review) == 1 ) {
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "리뷰 등록이 완료되었습니다.");
			return mv;

		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "리뷰 등록시 문제가 있습니다.");
			return mv;
		}
		
	}
}


