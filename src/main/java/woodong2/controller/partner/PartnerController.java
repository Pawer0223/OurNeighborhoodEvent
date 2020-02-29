package woodong2.controller.partner;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import woodong2.common.functions.CommonFunctions;
import woodong2.service.common.EventInfosService;
import woodong2.service.common.PtnInfosService;
import woodong2.service.common.ReviewInfosService;
import woodong2.vo.common.EventInfos;
import woodong2.vo.common.Paging;
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
	public ModelAndView registEventPage(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		UserInfos loginInfo = (UserInfos)session.getAttribute("login");
		
		
		// 로그인 계정의 PTN_CD값으로 파트너 명, 동네정보조회
		PtnInfos ptnInfo = ptnInfosService.getPtnInfo(loginInfo.getPtnCd());
		
		ModelAndView mv = new ModelAndView("/ptn/registEvent");
		
		mv.addObject("ptnInfo" , ptnInfo);
		
		return mv;
	}
	
}


