package woodong2.controller.normal;

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
public class NormalController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;
	
	private static final String EVENT_PIC_SUB_DIR = "eventPics";
	
	private CommonFunctions comnFn = new CommonFunctions();

	// 페이징 처리를 위한 이벤트 리스트 조회
	@RequestMapping(value = "/eventInfos/selectEventInfos2.do")
	public ModelAndView selectEventInfos(Paging paging,
			@RequestParam(value="nowPage", required=false) String nowPage, 
			@RequestParam(value="cntPerPage", required=false) String cntPerPage) throws Exception {

		ModelAndView mv = new ModelAndView("/main/events");
		
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
}


