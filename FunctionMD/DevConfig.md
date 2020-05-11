## 개발 작업환경 설정정보

### <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/webapp/WEB-INF/web.xml"> web.xml </a>
- 모든 Web Application은 반드시 하나의 web.xml파일을 가져야 한다.
- web.xml파일의 설정들은 Web Application 시작시 메모리에 로딩.

  1. contextConfigLocation
  - WAS를 실행하기 전, &lt;context-param&gt; 태그에 전역 파라미터를 설정.
  - 파라미터의 이름은 contextConfigLocation.
  - 미리 생성할 객체들의 정보가 정의 된 설정파일의 경로를 value로 작성.
  - [ context-\*.xml ] 로 지정된 파일들에 객체 정보들을 구분하여 정의하였음.

      1-1) <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/Sample_context-datasource_for_Git.xml"> DB관련 객체 </a>

       - 커넥션 풀(connection pool) 라이브러리 [ [ 참조 ] ](https://d2.naver.com/helloworld/5102792)
       - DB접속정보
       - 콘솔창의 수행쿼리 출력설정정보

      1-2) <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/context-mapper.xml"> context-mapper.xml </a>

      - MyBatis의 sqlSession정보 ( DAO파일에서 SqlSessionTemplate클래스 활용 )
      
      1-3) <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/context-security.xml"> countext-security.xml </a>

      - SpringSecurity 설정정보
      
      1-4) <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/context-root.xml"> context-root.xml </a>

      - 에러메시지 properties파일 참조를위한 설정정보


  2. 호출 서블릿 설정정보

      2-1) <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/webapp/WEB-INF/config/action-servlet.xml"> action-servlet.xml </a>
      
      - Interceptor정보

      - View파일 찾기위한정보

      - 파일업로드시 참조되는 MultipartResolver정보

### <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/log4j.xml"> log4j.xml </a>

- LOG4J를 활용한 로깅
