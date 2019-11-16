package first.loginAction.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	@RequestMapping(value = "/login/start.do")
	public ModelAndView start() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/index");
		return mv;
	}
}


