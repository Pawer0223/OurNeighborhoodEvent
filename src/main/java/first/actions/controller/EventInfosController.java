package first.actions.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/eventInfos/eventDetailInfo.do")
	public ModelAndView contact() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/events-single");
		return mv;
	}
}


