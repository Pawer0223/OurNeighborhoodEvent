package first.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN = "login";
	private static Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		
		HttpSession httpSession = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userInfo = modelMap.get("login");
		
		if ( userInfo != null ){
			log.debug("======================================LOGIN SUCCESS======================================");
			httpSession.setAttribute("login", userInfo);
			response.sendRedirect("/first/main/start.do");
		}else {
			log.debug("======================================LOGIN FAIL======================================");
			// 로그인 실패
			response.sendRedirect("/");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		
		// 기존의 로그인 정보제거
		if ( httpSession.getAttribute(LOGIN) != null ) {
			log.debug("======================================CLEAR LOGIN DATA BEFORE======================================");
			httpSession.removeAttribute(LOGIN);
		}
		
		return true;
	}
	

}
