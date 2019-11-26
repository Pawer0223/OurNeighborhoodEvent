package first.actions.service;

import java.util.List;
import java.util.Map;

import first.actions.model.MenuList;

public interface MenuListService {

	List<Map<String, MenuList>> selectMenu(String userGbnCd) throws Exception;

}
