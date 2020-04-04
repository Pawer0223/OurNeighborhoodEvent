package woodong2.controller.partner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventInfosService;
import woodong2.service.common.PtnInfosService;
import woodong2.service.common.ReviewInfosService;
import woodong2.utilities.function.CommonFunctions;
import woodong2.vo.common.EventInfos;
import woodong2.vo.common.PtnInfos;
import woodong2.vo.common.UserInfos;

@Controller
@RequestMapping(value = "/ptn")
public class PartnerController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;
	
	private static final String EVENT_PIC_SUB_DIR = "eventPics";
	
	private CommonFunctions comnFn = new CommonFunctions();

	@RequestMapping(value = "/registEventPage.do")
	public ModelAndView registEventPage(HttpServletRequest request, Authentication authentication) throws Exception {
		
		HttpSession session = request.getSession();
		
		UserInfos loginInfo = (UserInfos)authentication.getPrincipal();
		
		// 로그인 계정의 PTN_CD값으로 파트너 명, 동네정보조회
		PtnInfos ptnInfo = ptnInfosService.getPtnInfo(loginInfo.getPtnCd());
		
		ModelAndView mv = new ModelAndView("/ptn/registEvent");
		
		mv.addObject("ptnInfo" , ptnInfo);
		
		return mv;
	}
	
	/**
	 * 이벤트 등록
	 * @param eventInfo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registEventInfos.do")
	public ModelAndView registEventInfos( EventInfos eventInfo, HttpServletRequest request, Authentication authentication) throws Exception {
		
		System.out.println(eventInfo.toString());

		ModelAndView mv = new ModelAndView("/ptn/registEvent");
		
		if ( eventInfo.getAmount()==null ) {
			eventInfo.setAmount(99999); // default Amount는 99999로 설정.
		}

		//등록될 EVENT_SEQ 값 가져오기 max+1
		String maxEventSeq = "";
		maxEventSeq = eventInfosService.getMaxEventSeq();
		eventInfo.setEventSeq(maxEventSeq);
		
		String uploadPath = "C:\\KTS_DEV\\newWorkSpace\\OurNeighborhoodEvent\\src\\main\\webapp\\resources\\upload\\" + EVENT_PIC_SUB_DIR;
		//이미지업로드
		String fileNm =comnFn.restore(eventInfo.getPictureFile(),uploadPath);

		log.info(" uploadPath : " + uploadPath );				

		eventInfo.setProductPic("\\resources\\upload\\" + EVENT_PIC_SUB_DIR+"\\"+fileNm);
		
		//로그인 세션에서 ptnCd값 등록
		UserInfos loginInfo = (UserInfos)authentication.getPrincipal();
		eventInfo.setPtnCd(loginInfo.getPtnCd());
		
		// 성공시1, 실패시0반환
		if( eventInfosService.registEventInfos(eventInfo) == 1 ) {
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


