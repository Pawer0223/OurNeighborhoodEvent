package first.loginAction.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.EventInfos;
import first.actions.model.ReviewInfos;
import first.actions.service.EventInfosService;
import first.actions.service.ReviewInfosService;

@Controller
public class TestController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;
	
	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	@RequestMapping(value = "/main/test.do")
	public ModelAndView selectEventList() throws Exception {
		
		ModelAndView mv = new ModelAndView("/temp/signUp");
		
		return mv;
	}
}


