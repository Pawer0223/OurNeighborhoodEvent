package woodong2.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import woodong2.vo.common.MenuList;

//MENU_LIST에 접근하는 DAO 클래스

@Repository("menuListDAO")
public class MenuListDAO extends AbstractDAO{

	public List<Map<String, MenuList>> selectMenu(String userGbnCd) {
		return (List<Map<String, MenuList>>)selectList("menuList.selectMenu",userGbnCd);
	}	
}
