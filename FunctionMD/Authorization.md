## SpringSecurity를 활용하여 계정별 지정된 권한이 있는 URL에만 접속하도록 제어 할 수 있다.

### 계정 별 권한 관리를 위해 신규 테이블 추가 ( AUTHORITY )

- AUTHORITY_NAME 컬럼에 계정 별 권한 명을 부여해준다.
- 권한명칭은 ROLE_* 형식으로 한다.
- 부여한 권한은 아래 3개로 구성하였다.
```
ROLE_NORMAL : 일반 사용자
ROLE_PARTNER : 파트너 등록 사용자
ROLE_ADMIN : 관리자
```




### 결과확인

![paging](../readmeSource/gif/paging.gif)


