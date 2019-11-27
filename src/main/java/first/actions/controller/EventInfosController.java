package first.actions.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.EventInfos;
import first.actions.service.EventInfosService;

@Controller
public class EventInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;

	@RequestMapping(value = "/eventInfos/eventDetailInfo.do")
	public ModelAndView eventDetail(HttpServletRequest request) throws Exception {
		
		String eventSeq = request.getParameter("eventSeq");
		
		EventInfos eventDetail = eventInfosService.eventDetailInfo(eventSeq);
		
		ModelAndView mv = new ModelAndView("/main/events-single");
		
		mv.addObject("eventDetail" , eventDetail );
		
		return mv;
	}
}


