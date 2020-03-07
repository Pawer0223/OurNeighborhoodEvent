## SpringSecurity를 활용한 로그인 세션관리를 할 수 있다.

### 1. 계정권한에 따른 메뉴리스트 출력

#### Header에 메뉴리스트 구성 : [ [ Header.jsp ] ]( https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/webapp/WEB-INF/jsp/com/mainPage/header.jsp )

- SpringSecurity에서 제공하는 tag라이브러리를 활용하여 로그인 계정의 권한을 체크한다.

ex)
```
<!-- 나의 정보는 일반사용자, 파트너에게 보인다.  -->
<sec:authorize access="hasAnyRole('ROLE_NORMAL', 'ROLE_PARTNER')">
  <div class="collapse navbar-collapse" id="ftco-nav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item"><a href="/nor/myInfoPage.do" class="nav-link">My Info</a></li>
    </ul>
  </div>
</sec:authorize>

<!-- 리뷰등록은 일반,파트너 에게만 보인다.  -->
<sec:authorize access="hasAnyRole('ROLE_NORMAL', 'ROLE_PARTNER')">
  <div class="collapse navbar-collapse" id="ftco-nav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item"><a href="/nor/registReviewPage.do" class="nav-link">Regist Review</a></li>
    </ul>
  </div>
</sec:authorize>
```

### 결과확인

- 비 로그인 : [ About, Contact, SignUp, Events, Login ]
![header_common](../readmeSource/gif/header_common.PNG)
- ROLE_NORMAL : [ About, Contact, SignUp, Events, My Info, Regist Review, Regist Store, Logout ]
![header_normal](../readmeSource/gif/header_normal.PNG)
- ROLE_PARTNER : [ About, Contact, SignUp, Events, My Info, Regist Review,Regist Event,Logout ]
![header_partner](../readmeSource/gif/header_partner.PNG)



