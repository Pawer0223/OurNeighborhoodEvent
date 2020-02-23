package woodong2.vo.common;

import java.io.Serializable;

//메뉴 
public class MenuList implements Serializable {

	// 사용자구분코드 
	private String userGbnCd;

	// 메뉴코드 
	private String menuCd;

	// 메뉴명 
	private String menuNm;
	
	// 서블릿 링크 명
	private String servletHref;

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

	public String getServletHref() {
		return servletHref;
	}

	public void setServletHref(String servletHref) {
		this.servletHref = servletHref;
	}

	@Override
	public String toString() {
		return "MenuList [userGbnCd=" + userGbnCd + ", menuCd=" + menuCd + ", menuNm=" + menuNm + ", servletHref="
				+ servletHref + "]";
	}

}