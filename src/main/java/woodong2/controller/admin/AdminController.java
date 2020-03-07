package woodong2.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/adm")
public class AdminController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/goAdminPage.do")
	public String registEventPage(HttpServletRequest request) throws Exception {
	
		return "/admin/adminPage";
	}
	
}


