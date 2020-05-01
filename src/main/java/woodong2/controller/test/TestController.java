package woodong2.controller.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/goApiSampleJSON.do")
	public String goApiSampleJSON(HttpServletRequest request) throws Exception {
		
		return "/test/apiSampleJSON";
	}
	
	@RequestMapping(value = "/kakaoAddress.do")
	public String kakaoAddress(HttpServletRequest request) throws Exception {
		
		return "/test/apiSampleJSON";
	}
	
	@RequestMapping(value = "/modelTest.do")
	public String modelTest(Model model) throws Exception {
		
		System.out.println(" 모델 테스트 . ");
		
		Map<String,Object> isModel = new HashMap<>();
		
		isModel.put("Test2", "강태산");
		
		model.addAttribute("Test","김밥집");
		
		
		return "/test/modelTest";
	}
}