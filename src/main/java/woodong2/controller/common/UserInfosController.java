package woodong2.controller.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woodng2.common.functions.CommonFunctions;
import woodong2.service.common.MenuListService;
import woodong2.service.common.UserInfosService;
import woodong2.vo.common.MenuList;
import woodong2.vo.common.UserInfos;

@Controller
public class UserInfosController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	
	@Resource(name = "menuListService")
	private MenuListService menuListService;
	
	private static final String PRIFLIE_SUB_DIR = "profile";
	
	private CommonFunctions comnFn = new CommonFunctions();

	@RequestMapping(value = "/userInfos/userRegistGo.do")
	public ModelAndView userRegistGo() throws Exception {

		ModelAndView mv = new ModelAndView("/main/registForm/registUser");

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

		ModelAndView mv = new ModelAndView("/main/registForm/registUser");


		if ( userInfo.getUserId().isEmpty() || userInfo.getUserPw().isEmpty() || userInfo.getUserPw2().isEmpty() || userInfo.getEmail().isEmpty()
				|| userInfo.getUserNm().isEmpty() || userInfo.getPictureFile().isEmpty() || userInfo.getPhoneNum().isEmpty() || userInfo.getNeighbor().isEmpty() ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "내용을 모두 입력해주세요");
			return mv;
		}

		if ( !userInfo.getUserPw2().equals(userInfo.getUserPw()) ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "비밀번호가 서로 일치하지 않습니다.");
			return mv;
		}

		// 파일업로드 수행, 이상이없으면 계정정보 inert수행한다.
		
		String url ="c:/"+comnFn.restore(userInfo.getPictureFile(),PRIFLIE_SUB_DIR);
		
		userInfo.setProfilePic(url);
		
		// 비밀번호 암호화
		userInfo.setUserPw(comnFn.makeEncrypt(userInfo.getUserPw()));

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
	public ModelAndView login( UserInfos userInfo , HttpServletRequest request ) throws Exception {

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
		
		//로그인시 입력비밀번호 암호화하여 비교
		userInfo.setUserPw(comnFn.makeEncrypt(userInfo.getUserPw()));
		
		UserInfos loginInfo = userInfosService.login(userInfo);
		
		// 로그인정보 존재하지 않을 때
		if ( loginInfo == null ) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "아이디 또는 PW정보가 올바르지 않습니다.");
			return mv;
		}else {
			// 존재한다면 세션 등록.
			
			// 존재한다면 계정등급에맞는 메뉴리스트 조회
			request.getSession().removeAttribute("menuList");
			
			List<Map<String, MenuList>> menuList= null ;

			menuList = menuListService.selectMenu(loginInfo.getUserGbnCd());
			
			List<MenuList> m = makeMenu(menuList);
			
			request.getSession().setAttribute("menuList", m);
			request.getSession().setAttribute("login", loginInfo);
			
			mv = new ModelAndView("/main/index");
			
			return mv;
		}
	}
	
	@RequestMapping(value = "/userInfos/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		
		request.getSession().invalidate();
		
		return "redirect:/main/start.do";
	}
	
	@RequestMapping(value = "/userInfos/userDeatail.do")
	public ModelAndView userDetail() throws Exception {
		
		ModelAndView mv = new ModelAndView("/main/subMenus/userDetail");

		return mv;
	}

	
	// 메뉴리스트 만들기위한 method
	private List<MenuList> makeMenu(List<Map<String, MenuList>> menuList){
		
		List<MenuList> m = new ArrayList<MenuList>();

		for ( int i = 0; i < menuList.size(); i ++ ) {

			Map<String,MenuList> menus = menuList.get(i);

			Iterator itr = menus.values().iterator();

			MenuList menu = new MenuList();

			while ( itr.hasNext()) {
				menu.setMenuNm((String)itr.next());
				menu.setServletHref((String)itr.next());
			}

			m.add(menu);
		}
		
		return m;
	}
}


