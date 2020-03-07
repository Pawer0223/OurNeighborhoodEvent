package woodong2.handler.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import woodong2.dao.common.UserInfosDAO;
import woodong2.vo.common.UserInfos;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private String username; // id인풋 tag name
	private String defaultUrl; // 로그인 성공시 이동할 URL 정보.
	
	@Autowired
	private UserInfosDAO userInfosDAO;
	
	// RequestCache는 로그인 화면을 보여주기 전 사용자 요청을 저장하고 꺼내올 수 있는 interface이다.
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	// 화면이동에 대한 규칙을 정의하는 부분을 interface이다.
	private RedirectStrategy redirectStragtegy = new DefaultRedirectStrategy();

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDefaultUrl() {
		return defaultUrl;
	}
	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
	
	@Override
	public String toString() {
		return "LoginSuccessHandler [username=" + username + ", defaultUrl=" + defaultUrl + "]";
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String requestUserName = request.getParameter(username);
		
		// 실패회수 초기화
		userInfosDAO.resetFailCnt(requestUserName);
		// 에러세션 지우기
		clearAuthenticationAttributes(request);
		// Redirect URL 작업.
		resultRedirectStrategy(request, response);
	}
	
	// redirectUrl 지정 메서드
	protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if ( savedRequest != null ) {
			String targetUrl = savedRequest.getRedirectUrl();
			log.info( " [ 로그인 성공 URL ] savedRequest.getRedirectUrl : " + targetUrl );
			redirectStragtegy.sendRedirect(request, response, targetUrl);
		}else {
			log.info( " [ 로그인 성공 URL ] savedRequest.getRedirectUrl : " + defaultUrl );
			redirectStragtegy.sendRedirect(request, response, defaultUrl);
		}
	}
	
	// 남아있는 에러세션이 있다면 지워준다.
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if( session == null ) return ;
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
