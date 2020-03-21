package woodong2.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/goApiSampleJSON.do")
	public String goApiSampleJSON(HttpServletRequest request) throws Exception {
		
		return "/test/apiSampleJSON";
	}
	
}