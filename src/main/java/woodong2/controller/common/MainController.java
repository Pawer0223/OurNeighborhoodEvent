package woodong2.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	// 메인페이지 호출
	@RequestMapping(value = "/com/start2.do")
	public String start() throws Exception {
		return "/authority/com/loginSuccess";
	}
	
	// 로그인 페이지
	@RequestMapping(value = "/secu/loginPage.do")
	public String goLoginPage() throws Exception {
		return "/authority/com/loginPage";
	}
	
	@RequestMapping(value="/page.do")
	public String page() throws Exception {
		return "/authority/com/page";
	}
	
	@RequestMapping(value="/admin/page.do")
	public String userPage() throws Exception {
		return "/authority/admin/adminPage";
	}
	
	@RequestMapping(value="/com/page.do")
	public String memberPage() throws Exception {
		return "/authority/com/comPage";
	}
	
	@RequestMapping(value="/partner/page.do")
	public String adminPage() throws Exception {
		return "/authority/partner/partnerPage";
	}
	
	
	
	
}


