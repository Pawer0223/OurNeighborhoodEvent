package first.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 비 로그인시 Events메뉴 조회 불가능.
 */
public class EventsInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(EventsInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		// 세션에서 login Check
		Object obj = session.getAttribute("login");

		if ( obj == null ){
			// 비 로그인시 로그인 화면으로 이동
			response.sendRedirect("/first/userInfos/loginPage.do");
			return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
		}

		// return 값 true = 컨트롤러 요청 URI로 감, false = 가지 않음.
		return true;
	}

	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}     

}
