## 개발 작업환경 설정정보

### <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/log4j.xml"> log4j.xml </a>

- LOG4J를 활용한 로깅

### <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/webapp/WEB-INF/web.xml"> web.xml </a>

  1. contextConfigLocation의 xml파일 정보

      1-1) <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/resources/config/spring/Sample_context-datasource_for_Git.xml"> context-datasource.xml </a>

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

