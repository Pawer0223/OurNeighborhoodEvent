package first.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * client -> controller 로 요청할 때, 그 요청을 처리할 메서드 하나(전처리기) 
 * controller -> client 로 응답할 때, 그 요청을 처리할 메서드 하나(후처리기)
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
		if ( log.isDebugEnabled()) {
			log.debug("====================================== START ======================================");
			log.debug(" Request URI \t: " + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler , ModelAndView modelAndView) throws Exception{
		if ( log.isDebugEnabled()) {
			log.debug("====================================== END ======================================\n");
		}
	}
}
