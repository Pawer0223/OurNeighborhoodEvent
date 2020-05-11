## 개발 작업환경 설정정보

## [ web.xml ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/webapp/WEB-INF/web.xml )
- 모든 Web Application은 반드시 하나의 web.xml파일을 가져야 한다.
- web.xml파일의 설정들은 Web Application 시작시 메모리에 로딩.

  ### Listner클래스 정보
  - WAS 수행 시 &lt;listener&gt; 태그가 등록되어있는 ContextLoaderListner 객체를 호출한다.
  - 이 객체는 내부적으로 ContextLoader부모 객체를 실행한다.
  - 이 객체에서 RootApplicationContext를 생성한다.
  - 이 컨테이너에는 웹과 관련이 없는 객체들을 저장한다.
  
  ### contextConfigLocation
  - WAS를 실행하기 전, &lt;context-param&gt; 태그에 전역 파라미터를 설정.
  - 파라미터의 이름은 contextConfigLocation.
  - 미리 생성할 객체들의 정보가 정의 된 설정파일의 경로를 value로 작성.
  - context-\*.xml 로 지정된 파일들에 객체 정보들을 구분하여 정의하였음.
  - ContextLoaderListner를 통해 context-\*.xml 들을 읽어들이고, RootApplicationContext 컨테이너에 웹과 관련이 없는 객체들이 생성된다.
  
  **Listner클래스가 RootApplicationContext 컨테이너를 생성 후, contextConfigLocation에 설정된 정보들을 읽어들여서 객체들을 생성한다.**

     1.[ context-datasource.xml ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/Sample_context-datasource_for_Git.xml )

     - dataSourceSpied > 커넥션 풀(connection pool) 라이브러리 [ [ 참조 ] ](https://d2.naver.com/helloworld/5102792)
     - datasource > log4jdbc-remix > 수행 쿼리 및 결과 테이블을 출력해준다.
     - transactionManager > 트랜잭션 관리하기 위함.

     2.[ context-mapper.xml ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/context-mapper.xml )

     - sqlSession객체 [ [ 참조 ] ]( http://mybatis.org/spring/ko/sqlsession.html )
      
     3.[ countext-security.xml ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/context-security.xml )

     - SpringSecurity 설정정보
      
     4.[ context-root.xml ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/context-root.xml )

     - messageSource > Security에러메시지를 정의한 properties파일의 경로를 정의 함.

  ### 호출 서블릿 설정정보
  - &lt;servlet-mapping&gt;태그에 요청 Servlet의 url-pattern을 지정한다.
  - &lt;servlet&gt;태그에 Servlet요청을 받아 Controller에게 전달 시켜 줄 수 있는 DispatcherServlet클래스 정보를 지정해준다.
  - DispatcherServlet은 param의 contextConfigLocation의 위치에 지정된 파일을 해석하여 servlet요청을 HandlerMapping을 통해 해당하는 Controller가 있는지 확인하여, 수행시킨다.
  
     1.[ action-servlet.xml ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/webapp/WEB-INF/config/action-servlet.xml )
      
     - Annotation의 Scan 범위 지정
     - @Transactional 어노테이션 적용을 위한 Proxy설정
     - Interceptor객체 정보
     - ViewResolver객체 정보
     - 파일업로드시 참조되는 MultipartResolver정보
     - resources파일 location 정보
     
  ### filter 정보
  - 필터는 스프링 컨텍스트 외부에 존재하여 스프링과 무관한 자원에 대해 동작한다.
  - Servlet Filter는 DispatcherServlet이전에 실행이 되는데, 필터가 동작하도록 지정된 자원의 앞단에서 요청내용을 변경하거나, 여러가지 체크를 수행할 수 있다.
  - 또한 자원의 처리가 끝난 후 응답내용에 대해서도 변경하는 처리를 할 수가 있다.
  - 인코딩 변환처리, XSS방어 등의 요청에 대한 처리로 사용된다.
  - [ Filter, Interceptor, Aop의 차이점 ]( https://goddaehee.tistory.com/154 )
  
  
  

