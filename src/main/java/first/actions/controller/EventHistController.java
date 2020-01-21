package first.actions.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventHistController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/main/contact2.do")
	public ModelAndView contact() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/contact");
		return mv;
		
	}
}


