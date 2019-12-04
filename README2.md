# OurNeighborhoodEvent

<p>
    <img src="https://img.shields.io/badge/version-1.0.0-rgb(26, 188, 156).svg" />
    <img alt="IDE" src="https://img.shields.io/badge/IDE-Eclipse Jee -rgb(26, 188, 156).svg" />
    <img src="https://img.shields.io/badge/Apache-8.5-green.svg" />
    <img src="https://img.shields.io/badge/spring-4.3.9-green.svg" />
    <img src="https://img.shields.io/badge/java-1.8-blue.svg" />  
    <img src="https://img.shields.io/badge/Mybatis-3.2.2-rgb(243, 156, 18).svg" />
    <img src="https://img.shields.io/badge/Oracle11g -rgb(243, 156, 18).svg" />
    <img src="https://img.shields.io/badge/bootstrap 4.3.7 -rgb(255, 204, 000).svg" />
</p>
<br>
## 우리동네 이벤트란 ??  
<br>
우리동네 이벤트는 자영업자들을 위한 효율적인 재고처리를 위하여 기획하게 되었습니다.
사장님 마음대로 우리동네에 이벤트( 가격할인 , 무료나눔 등 )를 등록하여 반복적인 일상에 소소한 즐거움을 줄 수 있기를 바랍니다.
<br>
  
## ERD 및 테이블 설명
<br>
![erd](./readmeSource/erd.png)
<br>
### 1. 사용자정보(USER_INFOS)
<br>

1-1) 사용자구분코드( USER_GBN_CD )
<br>

- NOR(일반유저) : 가게등록 및 이벤트 참여가능.


- PTN(사업자) : 이벤트 등록 및 참여가능


- ADM(관리자) : 사이트 관리가능

<br>
1-2) 사업자코드 ( PTN_CD )
<br>

- 신규 사업자 등록 시 UPDATE , 최초 계정 등록시 NULL

<br>
1-3) 로그인오류 횟수 ( LGN_ERR_CNT )
<br>

- 로그인 실패 시 CNT증가


- 로그인 성공 시 0으로 초기화

<br>
1-4) 최종로그인 일시 ( LST_LGN_DATE )
<br>

- 로그인 5회이상 실패시 SYSDATE로 UPDATE


- 24시간이 지난 후 최초로그인 성공 시 NULL로 UPDATE 수행

<br>
### 2. 사업자정보( PTN_INFOS )

<br>
2-1) 사업자ID ( PTN_CD )
<br>

- PXXXXX 형태로 저장

<br>
### 3. 이벤트정보( EVENT_INFOS )
<br>
<br>
3-1) 이벤트 번호( EVENT_SEQ )
<br>

- EXXXXXX 형태로 저장

<br>
3-2) 이벤트 진행상태 ( EVENT_STATUS )
<br>
- WORK : 진행 중


- END : 종료

<br>
3-3) 배달가능 여부 ( DELIVERY_YN )
<br>

- Y : 가능 , 이벤트 화면에서 오토바이 표시


- N : 불가능

<br>
3-4 ) 인덱스 : EVENT_INFOS_IDX01(PTN_CD, EVENT_SEQ)
<br>

- 용도 : 파트너 별로 진행 이벤트 내역을 조회하기 위함

<br>
### 4. 이벤트 참여이력( EVENT_HIST )
<br>

4-1) 참여상태( PART_STATUS )
<br>

- COM : 결제완료


- CAN : 결제취소


- REDO : 취소 후 다시결제 ( 동일한 EVENT_SEQ,USER_ID로 CAN의 이력이 존재하는 경우 등록 됨 )

<br>
4-2) 이벤트 진행상태 ( EVENT_STATUS )
<br>

- WORK : 진행 중


- END : 종료

<br>
### 5. 리뷰정보 ( REVIEW_INFOS )
<br>

5-1) 리뷰 번호( REVIEW_SEQ )
<br>

- RXXXXXX 형태로 저장

<br>
### 6. 메뉴 ( MENU_LIST )
<br>

6-1) 사용자구분코드 ( USER_GBN_CD )
<br>

- 로그인 계정의 USER_GBN_CD에 따른 메뉴리스트 출력


- 비 로그인(COM) : 로그인, 회원가입 메뉴


- 일반(NOR) : 사업자등록, 이벤트참여


- 사업자(PTN) : 리뷰등록, 이벤트등록, 이벤트참여


- 관리자 : 메뉴관리, 리뷰관리, 이벤트관리


6-2) 메뉴코드 ( MENU_CD )
<br>

- 사용자구분코드 별로 MENU_CD 존재


6-3) 서블릿 링크 ( SERVLET_HREF )
<br>

- 해당 메뉴호출 시 수행되는 Servlet정보


<br>
## 주요 기능
<br>



