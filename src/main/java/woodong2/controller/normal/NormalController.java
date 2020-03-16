package woodong2.controller.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventHistService;
import woodong2.service.common.EventInfosService;
import woodong2.service.common.PtnInfosService;
import woodong2.service.common.ReviewInfosService;
import woodong2.service.common.UserInfosService;
import woodong2.utilities.function.CommonFunctions;
import woodong2.vo.common.Paging;
import woodong2.vo.common.PtnInfos;
import woodong2.vo.common.ReviewInfos;
import woodong2.vo.common.UserInfos;

@Controller
@RequestMapping("/nor")
public class NormalController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;
	
	@Resource(name = "eventHistService")
	private EventHistService eventHistService;
	
	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	
	private static final String EVENT_PIC_SUB_DIR = "eventPics";
	
	private CommonFunctions comnFn = new CommonFunctions();

	// 이벤트 리스트조회
	@RequestMapping(value = "/selectEventInfos.do")
	public ModelAndView selectEventInfos(Paging paging,
			@RequestParam(value="nowPage", required=false) String nowPage, 
			@RequestParam(value="cntPerPage", required=false) String cntPerPage) throws Exception {

		ModelAndView mv = new ModelAndView("/nor/events");
		
		int total = eventInfosService.getEventCount();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "9";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "9";
		}
		
		paging = new Paging(total , Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
		
		mv.addObject("paging", paging);
		mv.addObject("eventInfos", eventInfosService.selectEventInfos(paging));

		return mv;
	}
	
	@RequestMapping(value = "/goRegistReview.do")
	public ModelAndView goReviewPage(HttpServletRequest request, Authentication authentication) throws Exception {
		
		ModelAndView mv = new ModelAndView("/com/mainPage/main");
		
		UserInfos loginInfo = (UserInfos)authentication.getPrincipal();
		
		List<Map<String,Object>> partEvents = eventHistService.participatedEvents(loginInfo.getUserId());
		
		HttpSession session = request.getSession();
		// main.jsp에서 noSearchEvents살아있으면 alert창 띄운다. 
		if ( partEvents == null || partEvents.isEmpty() ) {
			session.setAttribute("messageType", "noSearchEvents");
			return mv;
		}else {
			mv = new ModelAndView("/nor/registReview");
			mv.addObject("participatedEvents" , partEvents );
			return mv;
		}
		
	}
	
	@RequestMapping(value = "/registReviews.do")
	public ModelAndView registReviews(ReviewInfos review, HttpServletRequest request, Authentication authentication) throws Exception {
		
		log.info(review.toString());
		
		ModelAndView mv = new ModelAndView("/nor/registReview");
		
		// 로그인 계정이 참여한 이벤트 정보를 먼저 조회한다.
		UserInfos loginInfo = (UserInfos)authentication.getPrincipal();
		
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
	
	/*
	 * 가게등록 페이지이동
	 */
	@RequestMapping(value = "/goRegistStore.do")
	public ModelAndView registStorePage() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/nor/registStore");
		return mv;
	}
	
	@RequestMapping(value = "/registPtnInfos.do")
	public ModelAndView registPtnInfos( PtnInfos ptnInfo, HttpServletRequest request , Authentication authentication ) throws Exception {
		
		log.info(ptnInfo.toString());

		ModelAndView mv = new ModelAndView("/nor/registStore");
		
		if ( ptnInfo.getFaxNo().isEmpty() ) {
			ptnInfo.setFaxNo("");
		}
		
		//등록될 ptnCd 값 가져오기 max+1
		String maxPtnCd = "";
		maxPtnCd = ptnInfosService.getMaxPtnCd();
		ptnInfo.setPtnCd(maxPtnCd);
		
		UserInfos userInfos = (UserInfos)authentication.getPrincipal();
		String userId = userInfos.getUserId();

		// 성공시1, 실패시0반환
		if( ptnInfosService.registPtnInfos(ptnInfo, userId) == 1 ) {
			
			// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			List<GrantedAuthority> updatedAuthorities = new ArrayList<>(authentication.getAuthorities());
			updatedAuthorities.add(new SimpleGrantedAuthority("ROLE_PARTNER"));
			Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), updatedAuthorities);
			SecurityContextHolder.getContext().setAuthentication(newAuth);
			
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "가게등록이 완료되었습니다.");
			return mv;
			
		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "해당 사업자 등록번호는 이미 등록되어있습니다.");
			return mv;
		}
	}
	
}


