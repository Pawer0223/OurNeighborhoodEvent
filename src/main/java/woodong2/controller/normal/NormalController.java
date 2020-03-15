package woodong2.controller.normal;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventHistService;
import woodong2.service.common.EventInfosService;
import woodong2.service.common.PtnInfosService;
import woodong2.service.common.ReviewInfosService;
import woodong2.utilities.function.CommonFunctions;
import woodong2.vo.common.Paging;
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
	
	
}


