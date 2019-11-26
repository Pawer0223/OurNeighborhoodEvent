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

	// 메인페이지 호출
	@RequestMapping(value = "/main/start.do")
	public ModelAndView start(String neighbor , HttpServletRequest request) throws Exception {

		if ( neighbor==null ) System.out.println(" 동네 검색되지 않았음 ");
		else {
			System.out.println( neighbor );
		}
		
		ModelAndView mv = new ModelAndView("/main/index");

		List<Map<String, MenuList>> menuList= null ;

		menuList = menuListService.selectMenu("COM");
		
		List<MenuList> m = makeMenu(menuList);
		
		request.setAttribute("menuList", m);

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

			while ( itr.hasNext()) {
				menu.setMenuNm((String)itr.next());
				menu.setServletHref((String)itr.next());
			}

			m.add(menu);
		}
		
		return m;
	}

	// events페이지 이동
	@RequestMapping(value = "/main/events.do")
	public ModelAndView events() throws Exception {

		ModelAndView mv = new ModelAndView("/main/events");

		List<Map<String, EventInfos>> latestEvents = eventInfosService.selectLatestEvents();

		mv.addObject("latestEvents", latestEvents);

		return mv;
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


