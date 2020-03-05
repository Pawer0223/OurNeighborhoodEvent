## SpringSecurity를 활용하여 계정별 지정된 권한이 있는 URL에만 접속하도록 제어 할 수 있다.

### 1.계정 별 권한 관리를 위해 신규 테이블 추가 ( AUTHORITY )

- AUTHORITY_NAME 컬럼에 계정 별 권한 명을 부여해준다.
- 권한명칭은 ROLE_* 형식으로 한다.
- 부여한 권한은 아래 3개로 구성하였다.
```
  ROLE_NORMAL : 일반 사용자
  ROLE_PARTNER : 파트너 등록 사용자
  ROLE_ADMIN : 관리자
```

### 2.Security 설정정보 추가.

```
  <intercept-url pattern="/nor/**" access="hasAnyRole('ROLE_NORMAL' , 'ROLE_PARTNER' , 'ROLE_ADMIN')" />
  <intercept-url pattern="/ptn/**" access="hasRole('ROLE_PARTNER')" />
  <intercept-url pattern="/adm/**" access="hasRole('ROLE_ADMIN')" />
  <intercept-url pattern="/**" access="permitAll" />
```

- /nor/** 로 호출되는 URL은 [ 일반,파트너,관리자 ]가 접근가능하다. <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/woodong2/controller/normal/NormalController.java">[ Controller ]</a>
- /ptn/** 로 호출되는 URL은 [ 파트너 ]만 접근이 가능하다. <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/woodong2/controller/partner/PartnerController.java">[ Controller ]</a>
- /adm/** 로 호출되는 URL은 [ 관리자 ]만 접근이 가능하다. <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/woodong2/controller/partner/AdminController.java">[ Controller ]</a>



### 결과확인


