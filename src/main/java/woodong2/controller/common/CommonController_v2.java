package woodong2.controller.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import woodong2.service.common.EventInfosService;
import woodong2.service.common.MenuListService;
import woodong2.service.common.ReviewInfosService;
import woodong2.service.common.UserInfosService;
import woodong2.utilities.function.CommonFunctions;
import woodong2.vo.common.EventInfos;
import woodong2.vo.common.Paging;
import woodong2.vo.common.UserInfos;

@Controller
@RequestMapping("/com/v2")
public class CommonController_v2 {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "eventInfosService")
	private EventInfosService eventInfosService;

	@Resource(name = "reviewInfosService")
	private ReviewInfosService reviewInfosService;

	@Resource(name = "menuListService")
	private MenuListService menuListService;
	
	@Resource(name = "userInfosService")
	private UserInfosService userInfosService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final String PRIFLIE_SUB_DIR = "profile";
	
	// 주소검색 API , SERVICE_KEY
	private final String SERVICE_KEY = "U01TX0FVVEgyMDIwMDMyMTE1MTgwMDEwOTU2NjE=";
	
	private CommonFunctions comnFn = new CommonFunctions();
	
	@RequestMapping(value = "/loginPage.do")
	public String loginSuccess() throws Exception {
		return "/v2/com/loginPage";
	}
	
	// services페이지 이동
	@RequestMapping(value = "/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/v2/com/mainPage/about");
		return mv;
	}

	// about페이지 이동
	@RequestMapping(value = "/contact.do")
	public ModelAndView contact() throws Exception {
		ModelAndView mv = new ModelAndView("/v2/com/mainPage/contact");
		return mv;
	}
	
	// 신규 계정등록
	@RequestMapping(value = "/userRegistGo.do")
	public ModelAndView userRegistGo() throws Exception {
		ModelAndView mv = new ModelAndView("/v2/com/registUser");
		return mv;
	}
	// 로그인실패
	@RequestMapping(value = "/loginFail.do")
	public ModelAndView loginFail() throws Exception {
		ModelAndView mv = new ModelAndView("/v2/com/loginFail");
		return mv;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		
		request.getSession().invalidate();
		return "redirect:/com/v2/start.do";
	}
	
	// 권한 없는 경우 
	@RequestMapping(value = "/accessDeniedPage.do")
	public String accessDeniedPage(HttpServletRequest request) throws Exception {
		
		return "/v2/com/accessDeniedPage";
	}
	
	// 메인페이지 호출
	@RequestMapping(value = "/start.do")
	public ModelAndView start(String neighbor , HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView("/v2/com/mainPage/main");

		Paging paging = new Paging();

		// 최근 6건 조회
		paging.setStart(1);
		paging.setEnd(6);
		paging.setCntPage(6);
		
		// 이벤트 정보조회
		List<EventInfos> latestEvents = eventInfosService.selectEventInfos(paging);

		mv.addObject("latestEvents", latestEvents);

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

		ModelAndView mv = new ModelAndView("/v2/com/registUser");
		
		MultipartFile profileUrl = userInfo.getPictureFile();
		
		String url = "";
		
		if ( !profileUrl.isEmpty()) {
			// 파일업로드 수행, 이상이없으면 계정정보 inert수행한다.
			url ="c:/"+comnFn.restore(userInfo.getPictureFile(),PRIFLIE_SUB_DIR);
		}

		userInfo.setProfilePic(url);
		
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
	 * 주소검색시 Ajax를 통해 주소정보를 호출해온다. 
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

		String stringUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do";
		StringBuilder urlBuilder = new StringBuilder(stringUrl); /*URL*/

		int currentPage= 1;
		int countPerPage= 10;
		String keyword = request.getParameter("keyword");            //요청 변수 설정 (키워드)

		System.out.println(" keyword : " + keyword);

		String resultType= "json";

		urlBuilder.append("?currentPage=" + currentPage ); /* 페이지 */
		urlBuilder.append("&countPerPage=" + countPerPage ); /* 건수 */
		urlBuilder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8")); /* 검색주소 */
		urlBuilder.append("&confmKey=" + SERVICE_KEY ); /* 발급받은 key */
		urlBuilder.append("&resultType=" + resultType ); /* 없으면 XML */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;

		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		System.out.println(sb.toString());

		JSONObject jsonObject = new JSONObject();

		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject)parser.parse(sb.toString());

		JSONObject results = (JSONObject)jsonObject.get("results");

		// 응답정보
		JSONObject common = (JSONObject)results.get("common");

		int totalCount= Integer.valueOf((String)common.get("totalCount"));

		System.out.println(" totalCount : " + totalCount );

		String[] jusos = new String[1];

		if ( totalCount < 1 ) {
			System.out.println(" 조회결과 없음. ");
			jusos[0] = "검색결과가 존재하지 않습니다.";
		}else {
			JSONArray juso = (JSONArray)results.get("juso");
			jusos = new String[juso.size()];

			for ( int i = 0 ; i < juso.size(); i ++ ) {
				JSONObject address = (JSONObject)juso.get(i);
				String roadAddr = (String)address.get("roadAddr");
				jusos[i] = roadAddr;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(jusos);
	}
	
	
}