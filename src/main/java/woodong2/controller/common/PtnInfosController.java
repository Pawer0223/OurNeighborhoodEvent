package woodong2.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.PtnInfosService;
import woodong2.service.common.UserInfosService;
import woodong2.vo.common.PtnInfos;
import woodong2.vo.common.UserInfos;

@Controller
public class PtnInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;
	
	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	

	
}


