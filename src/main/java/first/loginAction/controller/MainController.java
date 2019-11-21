package first.loginAction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	// 메인페이지 호출
	@RequestMapping(value = "/main/start.do")
	public ModelAndView start() throws Exception {
		ModelAndView mv = new ModelAndView("/main/index");
		return mv;
	}
	
	// events페이지 이동
	@RequestMapping(value = "/main/events.do")
	public ModelAndView events() throws Exception {
		ModelAndView mv = new ModelAndView("/main/events");
		return mv;
	}
	
	// services페이지 이동
	@RequestMapping(value = "/main/services.do")
	public ModelAndView services() throws Exception {
		ModelAndView mv = new ModelAndView("/main/services");
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


