package woodong2.handler.security;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import woodong2.dao.common.UserInfosDAO;
import woodong2.vo.common.UserInfos;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	private String username ;  			// 로그인 id값이 들어오는 input태그 name
	private String password ;		// 로그인 pw값이 들어오는 input태그 name
	private String exceptionMsgName ;		// 예외 메시지를 REQUEST의 ATTRIBUTE에 저장할 때 사용
	private String defaultFailureUrl ;		// 화면에 보여줄 url(로그인 화면)
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	UserInfosDAO userInfosDAO;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExceptionMsgName() {
		return exceptionMsgName;
	}
	public void setExceptionMsgName(String exceptionMsgName) {
		this.exceptionMsgName = exceptionMsgName;
	}
	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}
	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}
	
	@Override
	public String toString() {
		return "LoginFailureHandler [username=" + username + ", password=" + password + ", exceptionMsgName="
				+ exceptionMsgName + ", defaultFailureUrl=" + defaultFailureUrl + "]";
	}
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("######### onAuthenticationFailure #########");
		
		String loginId = request.getParameter(username);
		String loginPw = request.getParameter(password);
		String errormsg = exception.getMessage(); 
		
		log.info(" 넘어온  EXCEPTION 클래스.. : " + exception.getClass());
		
		if(exception instanceof BadCredentialsException) {
			// 잠긴계정인지 확인하여, errormsg변경해준다.
			boolean userUnLock = true;
			userUnLock = failCnt(loginId);
			if ( !userUnLock )
				errormsg = messageSource.getMessage("AccountStatusUserDetailsChecker.disabled", null , Locale.KOREA);
			else
				errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", null , Locale.KOREA);
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.InternalAuthentication", null , Locale.KOREA); 
		} else if(exception instanceof DisabledException) {
			errormsg = messageSource.getMessage("AccountStatusUserDetailsChecker.disabled", null , Locale.KOREA);
		} else if(exception instanceof CredentialsExpiredException) {
			errormsg = messageSource.getMessage("AccountStatusUserDetailsChecker.expired", null , Locale.KOREA);
		} else if(exception instanceof UsernameNotFoundException) {
			Object[] args = new String[] { loginId } ;
			errormsg = messageSource.getMessage("DigestAuthenticationFilter.usernameNotFound", args , Locale.KOREA);
		} else if(exception instanceof AccountExpiredException) {
			errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.expired", null , Locale.KOREA);
		} else if(exception instanceof LockedException) {
			errormsg = messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.locked", null , Locale.KOREA);
		} 
		
		request.setAttribute(username, loginId);
		request.setAttribute(password, loginPw);
		request.setAttribute(exceptionMsgName, errormsg);
		
		log.info(" exception.getMessage() : " + exception.getMessage() );
		
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
	
	private boolean failCnt(String loginId) {
		
		// 계정이 잠겼으면 추가로 실패횟수 증가시키지않고, true를 return한다.
		boolean userUnLock = true;

		// 실패횟수 select
		UserInfos userInfo = userInfosDAO.getUserInfo(loginId);
		
		userUnLock = userInfo.isEnabled();

		// 계정이 활성화 되어있는 경우에만 실패횟수와, Enabled설정을 변경한다.
		// Enabled설정은 실패횟수가 5이상일 때 바뀐다.
		if ( userUnLock ) {
			if( userInfo.getLgnErrCnt()< 5 )
				userInfosDAO.loginFailCntUp(loginId);
			else
				userInfosDAO.changeEnabled(loginId);
		}
		return userUnLock;
	}
}
