package first.actions.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.PtnInfos;
import first.actions.model.UserInfos;
import first.actions.service.PtnInfosService;
import first.actions.service.UserInfosService;

@Controller
public class PtnInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;
	
	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	
	private static String PTN_GBN_CD = "PTN";

	@RequestMapping(value = "/ptnInfos/registStorePage.do")
	public ModelAndView registStorePage() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/registForm/registStore");
		return mv;
	}
	
	@RequestMapping(value = "/ptnInfos/registPtnInfos.do")
	public ModelAndView registPtnInfos( PtnInfos ptnInfo, HttpServletRequest request ) throws Exception {
		
		System.out.println(ptnInfo.toString());

		ModelAndView mv = new ModelAndView("/main/registForm/registStore");
		
		if ( ptnInfo.getFaxNo().isEmpty() ) {
			ptnInfo.setFaxNo("");
		}

		if ( ptnInfo.getBizrRegNo().isEmpty() || ptnInfo.getPtnNm().isEmpty() || ptnInfo.getRpstNm().isEmpty() || ptnInfo.getRpstTel().isEmpty() ||
				ptnInfo.getNeighbor().isEmpty() || ptnInfo.getAddNo().isEmpty()) {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "내용을 모두 입력해주세요");
			return mv;
		}
		
		//등록될 ptnCd 값 가져오기 max+1
		String maxPtnCd = "";
		maxPtnCd = ptnInfosService.getMaxPtnCd();
		ptnInfo.setPtnCd(maxPtnCd);

		// 성공시1, 실패시0반환
		if( ptnInfosService.registPtnInfos(ptnInfo) == 1 ) {
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "가게등록이 완료되었습니다.");
			
			HttpSession session = request.getSession();
			
			// 가게등록시 계정정보 변경. ( PTN_CD입력, USER_GBN_CD = 'PTN' 변경 )
			UserInfos loginInfo = (UserInfos)session.getAttribute("login");
			loginInfo.setPtnCd(maxPtnCd);
			loginInfo.setUserGbnCd(PTN_GBN_CD);
			userInfosService.updatePtnCd(loginInfo);
			
			// USER_GBN_CD값 변경에 따른 MENU_LIST출력을 위해 로그인 세션정보 변경 해줌.
			session.removeAttribute("login");
			session.setAttribute("login", loginInfo);
			
			return mv;
			
		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "해당 사업자 등록번호는 이미 등록되어있습니다.");
			return mv;
		}
	}
	
}


