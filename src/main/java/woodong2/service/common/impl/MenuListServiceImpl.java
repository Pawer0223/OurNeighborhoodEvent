package woodong2.service.common.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woodong2.dao.common.MenuListDAO;
import woodong2.service.common.MenuListService;
import woodong2.vo.common.MenuList;

@Service("menuListService")
public class MenuListServiceImpl implements MenuListService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="menuListDAO")
	private MenuListDAO menuLisDAO;

	@Override
	public List<Map<String, MenuList>> selectMenu(String userGbnCd) throws Exception {
		// TODO Auto-generated method stub
		return menuLisDAO.selectMenu(userGbnCd);
	}
	
	
}
