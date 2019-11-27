package first.actions.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.EventInfos;
import first.actions.service.EventInfosService;
import first.actions.service.ReviewInfosService;

@Controller
public class EventInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	@RequestMapping(value = "/eventInfos/eventDetailInfo.do")
	public ModelAndView eventDetail(HttpServletRequest request) throws Exception {
		
		String eventSeq = request.getParameter("eventSeq");
		
		EventInfos eventDetail = eventInfosService.eventDetailInfo(eventSeq);
		List<Map<String, Object>> reviewDetail = reviewInfosService.reviewSearch(eventSeq);
		
		ModelAndView mv = new ModelAndView("/main/events-single");
		
		mv.addObject("eventDetail" , eventDetail );
		
		if ( reviewDetail != null ) mv.addObject("reviewDetail", reviewDetail);		
		
		return mv;
	}
}


