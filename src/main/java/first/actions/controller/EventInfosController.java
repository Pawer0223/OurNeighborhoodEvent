package first.actions.controller;

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

import first.actions.model.EventInfos;
import first.actions.model.PtnInfos;
import first.actions.model.UserInfos;
import first.actions.service.EventInfosService;
import first.actions.service.PtnInfosService;
import first.actions.service.ReviewInfosService;
import first.common.commonFn.CommonFunctions;

@Controller
public class EventInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;
	
	private static final String EVENT_PIC_SUB_DIR = "eventPics";
	
	private CommonFunctions comnFn = new CommonFunctions();

	@RequestMapping(value = "/eventInfos/eventDetailInfo.do")
	public ModelAndView eventDetail(HttpServletRequest request) throws Exception {
		
		String ptnCd = request.getParameter("ptnCd");
		
		EventInfos eventDetail = eventInfosService.eventDetailInfo(ptnCd);
		List<Map<String, Object>> reviewDetail = reviewInfosService.reviewSearch(ptnCd);
		
		ModelAndView mv = new ModelAndView("/main/events-single");
		
		mv.addObject("eventDetail" , eventDetail );
		
		if ( reviewDetail != null ) mv.addObject("reviewDetail", reviewDetail);		
		
		return mv;
	}
	
	// events페이지 이동
	@RequestMapping(value = "/eventInfos/events.do")
	public ModelAndView events() throws Exception {

		ModelAndView mv = new ModelAndView("/main/events");

		List<Map<String, EventInfos>> latestEvents = eventInfosService.selectLatestEvents();

		mv.addObject("latestEvents", latestEvents);

		return mv;
	}
	
	@RequestMapping(value = "/eventInfos/registEvent.do")
	public ModelAndView registStore(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		UserInfos loginInfo = (UserInfos)session.getAttribute("login");
		
		
		// 로그인 계정의 PTN_CD값으로 파트너 명, 동네정보조회
		PtnInfos ptnInfo = ptnInfosService.getPtnInfo(loginInfo.getPtnCd());
		
		ModelAndView mv = new ModelAndView("/main/registForm/registEvent");
		
		mv.addObject("ptnInfo" , ptnInfo);
		
		return mv;
	}
	
	@RequestMapping(value = "/eventInfos/insertEventInfos.do")
	public ModelAndView insertEventInfos( EventInfos eventInfo, HttpServletRequest request ) throws Exception {
		
		System.out.println(eventInfo.toString());

		ModelAndView mv = new ModelAndView("/main/registForm/registEvent");
		
		if ( eventInfo.getAmount()==null ) {
			eventInfo.setAmount(99999);
		}

		if ( eventInfo.getPtnNm().isEmpty() || eventInfo.getNeighbor().isEmpty() || eventInfo.getEventNm().isEmpty() || eventInfo.getEventDesc().isEmpty()
				|| eventInfo.getProduct().isEmpty() || eventInfo.getPictureFile().isEmpty() || eventInfo.getOriginPrice()==null || eventInfo.getEventPrice()==null
				|| eventInfo.getAmount()==null || eventInfo.getDeliveryYn().isEmpty() ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "내용을 모두 입력해주세요");
			return mv;
		}
		
		//등록될 EVENT_SEQ 값 가져오기 max+1
		String maxEventSeq = "";
		maxEventSeq = eventInfosService.getMaxEventSeq();
		eventInfo.setEventSeq(maxEventSeq);
		
		//이미지업로드
		String url ="c:/"+comnFn.restore(eventInfo.getPictureFile(),EVENT_PIC_SUB_DIR);
		eventInfo.setProductPic(url);
		
		//로그인 세션에서 ptnCd값 등록
		UserInfos loginInfo = (UserInfos)request.getSession().getAttribute("login");
		eventInfo.setPtnCd(loginInfo.getPtnCd());
		

		// 성공시1, 실패시0반환
		if( eventInfosService.insertEventInfo(eventInfo) == 1 ) {
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "이벤트 등록이 완료되었습니다.");
			
			return mv;
			
		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "이벤트 등록시 문제가 있습니다.");
			return mv;
		}
	}
}


