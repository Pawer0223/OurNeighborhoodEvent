package first.actions.controller;

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

import first.actions.model.EventInfos;
import first.actions.model.MenuList;
import first.actions.model.UserInfos;
import first.actions.service.EventInfosService;
import first.actions.service.MenuListService;
import first.actions.service.ReviewInfosService;

@Controller
public class MainController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;

	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	@Resource(name = "menuListService")
	private MenuListService menuListService;
	
	private static String COM = "COM";

	// 메인페이지 호출
	@RequestMapping(value = "/main/start.do")
	public ModelAndView start(String neighbor , HttpServletRequest request) throws Exception {

		if ( neighbor==null ) System.out.println(" 동네 검색되지 않았음 ");
		else {
			System.out.println( neighbor );
		}
		
		ModelAndView mv = new ModelAndView("/main/index");

		List<Map<String, MenuList>> menuList= null ;
		
		UserInfos loginInfo = (UserInfos)request.getSession().getAttribute("login");
		
		
		/*
		 * 1. 비 로그인시 COM으로 조회
		 * 
		 * 2. 로그인 수행 후 USER_GBN_CD값이 바뀌는 경우
		 * 
		 * 2-1) NOR유저가 가게등록 하였을 때 
		 * 
		 */
		if ( loginInfo == null ) {
			
			// USER_GBN_CD값도 별도의 세션에 보관.
			request.getSession().setAttribute("userGbnCd", COM);
			
			menuList = menuListService.selectMenu(COM);
			List<MenuList> m = makeMenu(menuList);
			request.getSession().setAttribute("menuList", m);
			
		}else {
			// 로그인 상태에서 userGbnCd 값이 바뀌었다면 메뉴리스트 다시조회.
			if ( loginInfo.getUserGbnCd() != (String)request.getSession().getAttribute("userGbnCd") ) {
				request.getSession().removeAttribute("userGbnCd");
				request.getSession().removeAttribute("menuList");
				
				request.getSession().setAttribute("userGbnCd", loginInfo.getUserGbnCd());
				
				menuList = menuListService.selectMenu(loginInfo.getUserGbnCd());
				List<MenuList> m = makeMenu(menuList);
				request.getSession().setAttribute("menuList", m);
			}
		}

		List<Map<String, EventInfos>> latestEvents = eventInfosService.selectLatestEvents();
		List<Map<String, Object>> latestReviews = reviewInfosService.selectLatestReviews();

		mv.addObject("latestEvents", latestEvents);
		mv.addObject("latestReviews", latestReviews);

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

	// services페이지 이동
	@RequestMapping(value = "/main/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/main/about");
		return mv;
	}

	// about페이지 이동
	@RequestMapping(value = "/main/contact.do")
	public ModelAndView contact() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/contact");
		return mv;
	}

	// services페이지 이동
	@RequestMapping(value = "/main/regist.do")
	public ModelAndView regist() throws Exception {
		ModelAndView mv = new ModelAndView("/temp/regist");
		return mv;
	}
}


