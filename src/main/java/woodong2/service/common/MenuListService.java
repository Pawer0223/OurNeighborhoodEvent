package woodong2.service.common;

import java.util.List;
import java.util.Map;

import woodong2.vo.common.MenuList;


public interface MenuListService {

	List<Map<String, MenuList>> selectMenu(String userGbnCd) throws Exception;

}
