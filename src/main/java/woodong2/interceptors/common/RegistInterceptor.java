package woodong2.interceptors.common;

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
public class RegistInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.debug("====================================== 등록 전 로그인 Check preHandle ======================================");

		// return 값 true = 컨트롤러 요청 URI로 감, false = 가지 않음.
		return true;
	}

	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		log.debug("====================================== 등록 전 로그인 Check postHandle ======================================");
		super.postHandle(request, response, handler, modelAndView);
	}     

}
