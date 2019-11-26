package first.actions.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.actions.model.MenuList;
import first.common.dao.AbstractDAO;

//MENU_LIST에 접근하는 DAO 클래스

@Repository("menuListDAO")
public class MenuListDAO extends AbstractDAO{

	public List<Map<String, MenuList>> selectMenu(String userGbnCd) {
		return (List<Map<String, MenuList>>)selectList("menuList.selectMenu",userGbnCd);
	}	
}
