package woodong2.controller.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventInfosService;
import woodong2.service.common.MenuListService;
import woodong2.service.common.ReviewInfosService;
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

	private static String COM = "COM";
	
	// 메인페이지 호출
	@RequestMapping(value = "/start.do")
	public ModelAndView start(String neighbor , HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView("/com/mainPage/main");

		List<Map<String, MenuList>> menuList= null ;

		UserInfos loginInfo = (UserInfos)request.getSession().getAttribute("login");

		// 비 로그인시
		if ( loginInfo == null ) {

			// USER_GBN_CD값도 별도의 세션에 보관.
			request.getSession().setAttribute("userGbnCd", COM);

			menuList = menuListService.selectMenu(COM);
			List<MenuList> m = makeMenu(menuList);
			request.getSession().setAttribute("menuList", m);

		}else { // 로그인 상태에서 
			    // 파트너 등록 userGbnCd 값이 바뀌었다면 메뉴리스트 다시조회.
			if ( loginInfo.getUserGbnCd() != (String)request.getSession().getAttribute("userGbnCd") ) {
				request.getSession().removeAttribute("userGbnCd");
				request.getSession().removeAttribute("menuList");

				request.getSession().setAttribute("userGbnCd", loginInfo.getUserGbnCd());

				menuList = menuListService.selectMenu(loginInfo.getUserGbnCd());
				List<MenuList> m = makeMenu(menuList);
				request.getSession().setAttribute("menuList", m);
			}
		}

		Paging paging = new Paging();

		paging.setStart(1);
		paging.setEnd(3);

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
	
	// 메뉴리스트 만들기위한 method
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