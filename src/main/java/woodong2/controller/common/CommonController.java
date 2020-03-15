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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventInfosService;
import woodong2.service.common.MenuListService;
import woodong2.service.common.ReviewInfosService;
import woodong2.service.common.UserInfosService;
import woodong2.utilities.function.CommonFunctions;
import woodong2.vo.common.Authority;
import woodong2.vo.common.EventInfos;
import woodong2.vo.common.MenuList;
import woodong2.vo.common.Paging;
import woodong2.vo.common.UserInfos;

@Controller
@RequestMapping("/com")
public class CommonController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;

	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	@Resource(name = "menuListService")
	private MenuListService menuListService;
	
	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	private static String COM = "COM";
	
	private static final String PRIFLIE_SUB_DIR = "profile";
	
	private CommonFunctions comnFn = new CommonFunctions();
	
	// 메인페이지 호출
	@RequestMapping(value = "/start.do")
	public ModelAndView start(String neighbor , HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView("/com/mainPage/main");

		Paging paging = new Paging();

		// 최근 3건조회 !
		paging.setStart(1);
		paging.setEnd(3);
		
		// 이벤트 정보조회
		List<EventInfos> latestEvents = eventInfosService.selectEventInfos(paging);
		List<Map<String, Object>> latestReviews = reviewInfosService.selectLatestReviews();

		mv.addObject("latestEvents", latestEvents);
		mv.addObject("latestReviews", latestReviews);

		return mv;
	}
		
	@RequestMapping(value = "/loginPage.do")
	public String loginSuccess() throws Exception {
		return "/com/loginPage";
	}
	
	// services페이지 이동
	@RequestMapping(value = "/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/com/mainPage/about");
		return mv;
	}

	// about페이지 이동
	@RequestMapping(value = "/contact.do")
	public ModelAndView contact() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/com/mainPage/contact");
		return mv;
	}
	
	// 신규 계정등록
	@RequestMapping(value = "/userRegistGo.do")
	public ModelAndView userRegistGo() throws Exception {
		ModelAndView mv = new ModelAndView("/com/registUser");
		return mv;
	}
	// 로그인실패
	@RequestMapping(value = "/loginFail.do")
	public ModelAndView loginFail() throws Exception {
		ModelAndView mv = new ModelAndView("/com/loginFail");
		return mv;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		
		request.getSession().invalidate();
		return "redirect:/com/start.do";
	}
	
	// 권한 없는 경우 
	@RequestMapping(value = "/accessDeniedPage.do")
	public String accessDeniedPage(HttpServletRequest request) throws Exception {
		
		return "/com/accessDeniedPage";
	}
	
	@RequestMapping(value = "/duplicateCheck.do")
	public void duplicateCheck( HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		String userId = request.getParameter("userId");

		int result = 0 ;

		if ( !userId.isEmpty() ) result = userInfosService.duplicateCheck(userId);

		// 없으면 0
		reponse.getWriter().write(result + "" );

	}
	
	@RequestMapping(value = "/userRegist.do")
	public ModelAndView userRegist( UserInfos userInfo , HttpServletRequest request ) throws Exception {

		log.info(userInfo.toString());

		ModelAndView mv = new ModelAndView("/com/registUser");
		
		MultipartFile profileUrl = userInfo.getPictureFile();
		
		String url = "";
		
		if ( !profileUrl.isEmpty()) {
			// 파일업로드 수행, 이상이없으면 계정정보 inert수행한다.
			url ="c:/"+comnFn.restore(userInfo.getPictureFile(),PRIFLIE_SUB_DIR);
		}

		userInfo.setProfilePic(url);
		
		// 비밀번호 암호화
		userInfo.setUserPw(passwordEncoder.encode(userInfo.getUserPw()));

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
	
	// 메뉴리스트 만들기위한 method, 이제는 사용되지않으나 추후 참고할수도있어서 냄겨두기..
	private List<MenuList> makeMenu(List<Map<String, MenuList>> menuList){

			List<MenuList> m = new ArrayList<MenuList>();

			for ( int i = 0; i < menuList.size(); i ++ ) {

				Map<String,MenuList> menus = menuList.get(i);

				Iterator itr = menus.values().iterator();

				MenuList menu = new MenuList();

				while( itr.hasNext()) {
					menu.setMenuNm((String)itr.next());
					menu.setServletHref((String)itr.next());
				}

				m.add(menu);
			}

			return m;
		}
}