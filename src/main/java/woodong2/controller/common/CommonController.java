package woodong2.controller.common;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import woodong2.service.common.EventInfosService;
import woodong2.service.common.MenuListService;
import woodong2.service.common.PtnInfosService;
import woodong2.service.common.ReviewInfosService;
import woodong2.service.common.UserInfosService;
import woodong2.utilities.function.APICommons;
import woodong2.utilities.function.APIParse;
import woodong2.utilities.function.CommonFunctions;
import woodong2.vo.common.EventInfos;
import woodong2.vo.common.Paging;
import woodong2.vo.common.PtnInfos;
import woodong2.vo.common.UserInfos;

@Controller
@RequestMapping("/com")
public class CommonController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;

	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	@Resource(name = "menuListService")
	private MenuListService menuListService;

	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	
	@Resource(name= "ptnInfosService")
	private PtnInfosService ptnInfosService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// private final String PRIFLIE_SUB_DIR = "profile";

	private CommonFunctions comnFn = new CommonFunctions();

	private APICommons apiComn = new APICommons();

	private APIParse apiParse = new APIParse();

	public enum API_KIND {
		Jusos, KaKao_Local;
	};

	@RequestMapping(value = "/loginPage.do")
	public String loginSuccess() throws Exception {
		return "/com/loginPage";
	}

	// services페이지 이동
	@RequestMapping(value = "/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/com/mainPage/about");
		return mv;
	}

	// about페이지 이동
	@RequestMapping(value = "/contact.do")
	public ModelAndView contact() throws Exception {
		ModelAndView mv = new ModelAndView("/com/mainPage/contact");
		return mv;
	}

	// 신규 계정등록
	@RequestMapping(value = "/userRegistGo.do")
	public ModelAndView userRegistGo() throws Exception {
		ModelAndView mv = new ModelAndView("/com/registUser");
		return mv;
	}
	// 로그인실패
	@RequestMapping(value = "/loginFail.do")
	public ModelAndView loginFail() throws Exception {
		ModelAndView mv = new ModelAndView("/com/loginFail");
		return mv;
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) throws Exception {

		request.getSession().invalidate();
		return "redirect:/com/start.do";
	}

	// 권한 없는 경우 
	@RequestMapping(value = "/accessDeniedPage.do")
	public String accessDeniedPage(HttpServletRequest request) throws Exception {

		return "/com/accessDeniedPage";
	}

	// 메인페이지 호출
	@RequestMapping(value = "/start.do")
	public ModelAndView start(String neighbor , HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView("/com/mainPage/main");

		Paging paging = new Paging();

		// 최근 3건조회 !
		paging.setStart(1);
		paging.setEnd(3);

		// 이벤트 정보조회
		
		// List<EventInfos> latestEvents = eventInfosService.selectEventInfos(paging);
		// List<Map<String, Object>> latestReviews = reviewInfosService.selectLatestReviews();
		
		List<EventInfos> latestEvents = new ArrayList<EventInfos>();
		EventInfos eventInfo = new EventInfos();
		latestEvents.add(eventInfo);
		
		List<Map<String, Object>> latestReviews = new ArrayList();
		// EventInfos eventInfo = new EventInfos();
		
		
		mv.addObject("latestEvents", latestEvents);
		mv.addObject("latestReviews", latestReviews);

		return mv;
	}

	@RequestMapping(value = "/duplicateCheck.do")
	public void duplicateCheck( HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		String userId = request.getParameter("userId");

		int result = 0 ;

		if ( !userId.isEmpty() ) result = userInfosService.duplicateCheck(userId);

		// 없으면 0
		reponse.getWriter().write(result + "" );

	}

	@RequestMapping(value = "/userRegist.do")
	public ModelAndView userRegist( UserInfos userInfo , HttpServletRequest request ) throws Exception {

		log.info(userInfo.toString());

		ModelAndView mv = new ModelAndView("/com/registUser");

		/*
	   MultipartFile profileUrl = userInfo.getPictureFile();

       String uploadPath=request.getSession().getServletContext().getRealPath("/resources/upload/")+PRIFLIE_SUB_DIR;     
	   String uploadPath = "C:\\KTS_DEV\\newWorkSpace\\OurNeighborhoodEvent\\src\\main\\webapp\\resources\\upload\\" + PRIFLIE_SUB_DIR;
       System.out.println(" request.getSession().getServletContext() : " + request.getSession().getServletContext() );


		if ( !profileUrl.isEmpty()) {
			// 파일업로드 수행, 이상이없으면 계정정보 inert수행한다.
			// url ="c:/"+comnFn.restore(userInfo.getPictureFile(),PRIFLIE_SUB_DIR);
			String fileNm = comnFn.restore(userInfo.getPictureFile(), uploadPath);
			userInfo.setProfilePic("\\resources\\upload\\" + PRIFLIE_SUB_DIR+"\\"+fileNm);
		}

		 */
		// 비밀번호 암호화
		userInfo.setUserPw(passwordEncoder.encode(userInfo.getUserPw()));

		// 성공시1, 실패시0반환
		if(userInfosService.registUser(userInfo) == 1 ) {
			request.getSession().setAttribute("messageType", "success");
			request.getSession().setAttribute("messageContent", "회원가입을 축하드립니다 !");
			return mv;
		}else {
			request.getSession().setAttribute("messageType", "error_message");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			return mv;
		}
	}

	/**
	 * 주소검색시 Ajax를 통해 주소정보를 호출해온다. - 카카오 map
	 * 
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/getAddrApiKaKao.do", produces="text/plain;charset=UTF-8")
	public String getAddrApiKaKao(HttpServletRequest request, ModelMap model, HttpServletResponse response) throws Exception {

		String query = request.getParameter("addressNm");
		log.info("kakao 조회 조건 : " + query );

		Map<String,Object> params = new TreeMap<String,Object>();

		params.put("query", URLEncoder.encode(query,"UTF-8")); /* 주소 */

		// API 호출하여 데이터 가져오기.
		StringBuilder sb = apiComn.callAPI(params,API_KIND.KaKao_Local.toString());
		log.info(sb.toString());

		// 호출 데이터 parse하여 반환받기.
		String result = apiParse.kakaoLocalParse(sb.toString());

		return result;
	}

	/**
	 * 주소검색시 Ajax를 통해 주소정보를 호출해온다. - 도로명 주소 사이트.
	 * 
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/getAddrApi.do", produces="text/plain;charset=UTF-8")
	public String getAddrApi(HttpServletRequest request, ModelMap model, HttpServletResponse response) throws Exception {

		int currentPage= 1;
		int countPerPage= 10;
		String resultType= "json";
		String keyword = request.getParameter("keyword"); //요청 변수 설정 (키워드)

		Map<String,Object> params = new TreeMap<String,Object>();

		params.put("(INT)currentPage", currentPage);/* 페이지 */
		params.put("(INT)countPerPage", countPerPage); /* 건수 */
		params.put("keyword", URLEncoder.encode(keyword, "UTF-8"));/* 검색주소 */
		params.put("confmKey", "MAIN_KEY"); /* 발급받은 key */
		params.put("resultType", resultType);/* 없으면 XML */

		log.info(" keyword : " + keyword);

		// API 호출하여 데이터 가져오기.
		StringBuilder sb = apiComn.callAPI(params,API_KIND.Jusos.toString());
		log.info(sb.toString());

		// 호출데이터 파싱하여 사용가능한 객체로 반환받기.
		String result = apiParse.jusosParse(sb.toString());

		return result;
	}

	@RequestMapping(value="/searchEvent.do")
	public ModelAndView searchEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView("/com/eventList");

		String latitude = request.getParameter("latitude"); //요청 변수 설정 (키워드)
		String longitude = request.getParameter("longitude"); //요청 변수 설정 (키워드)

		log.info(" 위도(latitude) : " + latitude + ", 경도(longitude) : " + longitude );

		mv.addObject("latitude",latitude);
		mv.addObject("longitude",longitude);
		
		PtnInfos ptnInfo = new PtnInfos();
		
		ptnInfo.setLatitude(latitude);
		ptnInfo.setLongitude(longitude);
		
		// 위도 경도 범위 내에 있는 가게의 위도,경도, 이벤트 정보를 조회 해오기.
		List<Map<String, Object>> nearEvents = ptnInfosService.getNearEvents(ptnInfo);
		
		System.out.println("##### " + nearEvents.toString());

		// 반환할 jsp 페이지 명.
		return mv;
	}

}