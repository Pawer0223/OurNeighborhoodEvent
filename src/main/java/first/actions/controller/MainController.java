package first.actions.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.EventInfos;
import first.actions.service.EventInfosService;
import first.actions.service.ReviewInfosService;

@Controller
public class MainController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	// 메인페이지 호출
	@RequestMapping(value = "/main/start.do")
	public ModelAndView start(String neighbor) throws Exception {
		
		if ( neighbor==null ) System.out.println(" 동네 검색되지 않았음 ");
		else {
			System.out.println( neighbor );
		}
		ModelAndView mv = new ModelAndView("/main/index");
		
		List<Map<String, EventInfos>> latestEvents = eventInfosService.selectLatestEvents();
		List<Map<String, Object>> latestReviews = reviewInfosService.selectLatestReviews();


		mv.addObject("latestEvents", latestEvents);
		mv.addObject("latestReviews", latestReviews);
		
		return mv;
	}
	
	// events페이지 이동
	@RequestMapping(value = "/main/events.do")
	public ModelAndView events() throws Exception {
		ModelAndView mv = new ModelAndView("/main/events");
		return mv;
	}
	
	// services페이지 이동
	@RequestMapping(value = "/main/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/main/about");
		return mv;
	}
	
	// about페이지 이동
	@RequestMapping(value = "/main/contact.do")
	public ModelAndView contact() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/contact");
		return mv;
	}
}


