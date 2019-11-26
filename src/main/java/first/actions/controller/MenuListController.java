package first.actions.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.MenuList;
import first.actions.model.UserInfos;
import first.actions.service.MenuListService;

@Controller
public class MenuListController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "menuListService")
	private MenuListService menuListService;

	@RequestMapping(value = "/menuList/selectMenu.do")
	public void selectMenu(HttpServletRequest request) throws Exception {
		
	}
}


