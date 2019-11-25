package first.actions.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.UserInfos;
import first.actions.service.UserInfosService;

@Controller
public class UserInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	

	@RequestMapping(value = "/userInfos/duplicateCheck.do")
	public void duplicateCheck( HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		
		String userId = request.getParameter("userId");
		
		
		
		if ( userId==null ) System.out.println(" inputId값이 null 값임 ");
		else {
			System.out.println( " inputId : " + userId );
		}
		
		int result = userInfosService.duplicateCheck(userId);
		
		System.out.println(result);
		// 없으면 0
		reponse.getWriter().write(result + "" );
		
	}
	
	@RequestMapping(value = "/userInfos/userRegist.do")
	public ModelAndView userRegist( UserInfos userInfo , HttpServletRequest request ) throws Exception {
		
		System.out.println(userInfo.toString());
		
		ModelAndView mv = new ModelAndView("/temp/signUp");
		
		
		if ( userInfo.getUserId().isEmpty() || userInfo.getUserPw().isEmpty() || userInfo.getUserPw2().isEmpty() || userInfo.getEmail().isEmpty()
			|| userInfo.getUserNm().isEmpty() || userInfo.getProfilePic().isEmpty() || userInfo.getPhoneNum().isEmpty() || userInfo.getNeighbor().isEmpty() ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "내용을 모두 입력해주세요");
			return mv;
		}
		
		if ( !userInfo.getUserPw2().equals(userInfo.getUserPw()) ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "비밀번호가 서로 일치하지 않습니다.");
			return mv;
		}
		
		// 성공시1, 실패시0반환
		if(userInfosService.registUser(userInfo) == 1 ) {
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "회원가입을 축하드립니다 !");
			return mv;
		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			return mv;
		}
		
	}
}


