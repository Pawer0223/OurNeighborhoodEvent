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
import woodong2.vo.common.AddressInfo;
import woodong2.vo.common.EventInfos;
import woodong2.vo.common.Paging;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final String PRIFLIE_SUB_DIR = "profile";
	
	private CommonFunctions comnFn = new CommonFunctions();
	
	// 주소검색 API , SERVICE_KEY
	private final String SERVICE_KEY = "U01TX0FVVEgyMDIwMDMyMTE1MTgwMDEwOTU2NjE=";
	
	// 주소검색 API , KAKAO
	private final String KAKAO_KEY = "87a1c0ac6fa481c008c408c7b819d530";
	
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
		List<EventInfos> latestEvents = eventInfosService.selectEventInfos(paging);
		List<Map<String, Object>> latestReviews = reviewInfosService.selectLatestReviews();

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
		
		MultipartFile profileUrl = userInfo.getPictureFile();
		
       //  String uploadPath=request.getSession().getServletContext().getRealPath("/resources/upload/")+PRIFLIE_SUB_DIR;     
		String uploadPath = "C:\\KTS_DEV\\newWorkSpace\\OurNeighborhoodEvent\\src\\main\\webapp\\resources\\upload\\" + PRIFLIE_SUB_DIR;
       // System.out.println(" request.getSession().getServletContext() : " + request.getSession().getServletContext() );
        
		log.info(" uploadPath : " + uploadPath );				
        
		if ( !profileUrl.isEmpty()) {
			// 파일업로드 수행, 이상이없으면 계정정보 inert수행한다.
			// url ="c:/"+comnFn.restore(userInfo.getPictureFile(),PRIFLIE_SUB_DIR);
			String fileNm = comnFn.restore(userInfo.getPictureFile(), uploadPath);
			userInfo.setProfilePic("\\resources\\upload\\" + PRIFLIE_SUB_DIR+"\\"+fileNm);
		}

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
		
		String stringUrl = "https://dapi.kakao.com/v2/local/search/address.json";
		StringBuilder urlBuilder = new StringBuilder(stringUrl); /*URL*/
		
		String query = request.getParameter("keyword");
		urlBuilder.append("?query=" + URLEncoder.encode(query,"UTF-8") ); /* 페이지 */
		StringBuilder sb = callKaKaoAPI(urlBuilder.toString());
		
		System.out.println(sb.toString());
		
		JSONObject jsonObject = new JSONObject();

		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject)parser.parse(sb.toString());
		
		JSONObject meta = (JSONObject)jsonObject.get("meta");
		long totalCount= (long)meta.get("total_count");
		
		log.info(" KaKao totalCount : " + totalCount );
		
		AddressInfo[] infos = new AddressInfo[1];

		if ( totalCount < 1 ) {
			log.info(" 조회결과 없음. ");
			
			AddressInfo info = new AddressInfo("0","0","검색결과가 존재하지 않습니다.");
			infos[0]=info;
		}else {
			
			JSONArray documents = (JSONArray)jsonObject.get("documents");
			
			infos = new AddressInfo[documents.size()];

			for ( int i = 0 ; i < documents.size(); i ++ ) {
				JSONObject address = (JSONObject)documents.get(i);
				
				String addressNm = (String)address.get("address_name");
				String x = (String)address.get("x");
				String y = (String)address.get("y");
				
//				System.out.println(" ### 변환 전 : x : " + x + " , y : " + y);
//				
//				String stringUrl2 = "https://dapi.kakao.com/v2/local/geo/transcoord.json";
//				StringBuilder urlBuilder2 = new StringBuilder(stringUrl2); /*URL*/
//				
//				urlBuilder.append("?x=" + x); 
//				urlBuilder.append("&y=" + y); 
//				urlBuilder.append("&input_coord=WTM"); 
//				urlBuilder.append("&output_coord=WGS84"); 
//				
//				StringBuilder sb2 = callKaKaoAPI(urlBuilder2.toString());
//				
//				JSONArray documents2 = (JSONArray)jsonObject.get("documents");
//				JSONObject address2 = (JSONObject)documents2.get(0);
//				x = (String)address2.get("x");
//				y = (String)address2.get("y");
//				
//				System.out.println("### 변환 후 : x : " + x + " , y : " + y);
				
				AddressInfo info = new AddressInfo(x,y,addressNm);
				
				infos[i] = info;
			}
		}
		Gson gson = new Gson();
		return gson.toJson(infos);
	}
	
	/**
	 * 주소검색시 Ajax를 통해 주소정보를 호출해온다. - 주소포탈 용도.
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
		String keyword = request.getParameter("keyword"); //요청 변수 설정 (키워드)

		log.info(" keyword : " + keyword);

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

		log.info(sb.toString());

		JSONObject jsonObject = new JSONObject();

		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject)parser.parse(sb.toString());

		JSONObject results = (JSONObject)jsonObject.get("results");

		// 응답정보
		JSONObject common = (JSONObject)results.get("common");

		int totalCount= Integer.valueOf((String)common.get("totalCount"));

		log.info(" totalCount : " + totalCount );

		String[] jusos = new String[1];

		if ( totalCount < 1 ) {
			log.info(" 조회결과 없음. ");
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
	
	@RequestMapping(value="/searchEvent.do")
	public ModelAndView searchEvent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("/com/eventList");
		
		String x = request.getParameter("x"); //요청 변수 설정 (키워드)
		String y = request.getParameter("y"); //요청 변수 설정 (키워드)
		
		System.out.println(" x 좌표 : " + x + ", y 좌표 : " + y );
		
		mv.addObject("x",x);
		mv.addObject("y",y);
		
		// 반환할 jsp 페이지 명.
		return mv;
	}
	
	private StringBuilder callKaKaoAPI(String stringUrl) throws Exception {
		
		StringBuilder urlBuilder = new StringBuilder(stringUrl); /*URL*/
		
		String auth = "KakaoAK " + KAKAO_KEY;
		
		URL url = new URL(urlBuilder.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		conn.setRequestProperty("User-Agent", "Java-Client");	// https 호출시 user-agent 필요
		conn.setRequestProperty("X-Requested-With", "curl");
		conn.setRequestProperty("Authorization", auth);
		
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
		
		
		return sb;
	}
	
}