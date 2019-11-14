package first.loginAction.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.loginAction.model.UserInfo;
import first.loginAction.service.LoginService;

@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "loginService")
	private LoginService loginService;

	@RequestMapping(value = "/login/login.do")
	public ModelAndView loginUser(UserInfo info) throws Exception {
		ModelAndView mv = new ModelAndView("/login/loginSuccesMain");
		
		UserInfo userInfo = loginService.login(info);
		
		System.out.println(" 타기전 : " + info.toString());

		if ( userInfo == null  ) System.out.println(" null 임 ");
		else {
			System.out.println( " else 안 : " + userInfo.toString());
		}

		mv.addObject("userInfo", userInfo);
		return mv;
	}
}


