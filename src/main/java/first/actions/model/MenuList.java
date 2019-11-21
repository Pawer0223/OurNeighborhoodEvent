package first.actions.model;

//메뉴 
public class MenuList {

	// 사용자구분코드 
	private String userGbnCd;

	// 메뉴코드 
	private String menuCd;

	// 메뉴명 
	private String menuNm;

	public String getUserGbnCd() {
		return userGbnCd;
	}

	public void setUserGbnCd(String userGbnCd) {
		this.userGbnCd = userGbnCd;
	}

	public String getMenuCd() {
		return menuCd;
	}

	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	// MenuList 모델 복사
	public void CopyData(MenuList param)
	{
		this.userGbnCd = param.getUserGbnCd();
		this.menuCd = param.getMenuCd();
		this.menuNm = param.getMenuNm();
	}

	@Override
	public String toString() {
		return "MenuList [userGbnCd=" + userGbnCd + ", menuCd=" + menuCd + ", menuNm=" + menuNm + "]";
	}


}