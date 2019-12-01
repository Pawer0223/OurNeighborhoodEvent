package first.actions.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.actions.model.PtnInfos;
import first.actions.service.PtnInfosService;

@Controller
public class PtnInfosController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "ptnInfosService")
	private PtnInfosService ptnInfosService;

	@RequestMapping(value = "/ptnInfos/registStore.do")
	public ModelAndView registStore() throws Exception {
		//		ModelAndView mv = new ModelAndView("/login/home");
		ModelAndView mv = new ModelAndView("/main/registForm/registStore");
		return mv;
	}
	
	@RequestMapping(value = "/ptnInfos/insertPtnInfos.do")
	public ModelAndView insertPtnInfos( PtnInfos ptnInfo, HttpServletRequest request ) throws Exception {
		
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

		// 성공시1, 실패시0반환
		if( ptnInfosService.inserStoreInfo(ptnInfo) == 1 ) {
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "가게등록이 완료되었습니다.");
			return mv;
		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "해당 사업자 등록번호는 이미 등록되어있습니다.");
			return mv;
		}
	}
	
}


