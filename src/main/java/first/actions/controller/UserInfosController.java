package first.actions.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/userInfos/registPage.do")
	public ModelAndView registPage() throws Exception {

		ModelAndView mv = new ModelAndView("/main/subMenus/signUp");

		return mv;
	}

	@RequestMapping(value = "/userInfos/loginPage.do")
	public ModelAndView loginPage() throws Exception {

		ModelAndView mv = new ModelAndView("/main/subMenus/login");

		return mv;
	}

	@RequestMapping(value = "/userInfos/duplicateCheck.do")
	public void duplicateCheck( HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		String userId = request.getParameter("userId");

		int result = 0 ;

		if ( !userId.isEmpty() ) result = userInfosService.duplicateCheck(userId);

		// 없으면 0
		reponse.getWriter().write(result + "" );

	}

	@RequestMapping(value = "/userInfos/userRegist.do")
	public ModelAndView userRegist( UserInfos userInfo , HttpServletRequest request ) throws Exception {

		System.out.println(userInfo.toString());

		ModelAndView mv = new ModelAndView("/main/subMenus/signUp");


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

	@RequestMapping(value = "/userInfos/login.do")
	public ModelAndView login( UserInfos userInfo , HttpServletRequest request , HttpSession session) throws Exception {

		if ( userInfo.getUserId() == null || userInfo.getUserPw() == null ) System.out.println("null"); 

		ModelAndView mv = new ModelAndView("/main/subMenus/login");

		if ( userInfo.getUserId().isEmpty() ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "ID를 입력해 주세요");
			return mv;

		}

		if ( userInfo.getUserPw().isEmpty() ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "PW를 입력해 주세요");
			return mv;

		}
		
		UserInfos loginInfo = userInfosService.login(userInfo);
		
		// 로그인정보 존재하지 않을 때
		if ( loginInfo == null ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "아이디 또는 PW정보가 올바르지 않습니다.");
			return mv;
		}
		
		if ( session.getAttribute("login") != null ) {
			session.removeAttribute("login");
		}
		
		session.setAttribute("login" , loginInfo);
		
		mv = new ModelAndView("/main/index");
		
		return mv;


	}
}


