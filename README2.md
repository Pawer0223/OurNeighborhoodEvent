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

## 우리동네 이벤트란 ??  

우리동네 이벤트는 자영업자들을 위한 효율적인 재고처리를 위하여 기획하게 되었습니다.
사장님 마음대로 우리동네에 이벤트( 가격할인 , 무료나눔 등 )를 등록하여 반복적인 일상에 소소한 즐거움을 줄 수 있기를 바랍니다.

  
## ERD 및 테이블 설명

![erd](./readmeSource/erd.png)

### 1. 사용자정보(USER_INFOS) : 기본 계정정보

### 1-1) 사용자구분코드( USER_GBN_CD )

- NOR(일반유저) : 가게등록 및 이벤트 참여가능.
- PTN(사업자) : 이벤트 등록 및 참여가능
- ADM(관리자) : 사이트 관리가능

### 1-2) 사업자코드 ( PTN_CD )

- 신규 사업자 등록 시 UPDATE , 최초 계정 등록시 NULL

### 1-3) 로그인오류 횟수 ( LGN_ERR_CNT )

- 로그인 실패 시 CNT증가

- 로그인 성공 시 0으로 초기화

### 1-4) 최종로그인 일시 ( LST_LGN_DATE )

- 로그인 5회이상 실패시 SYSDATE로 UPDATE

- 24시간이 지난 후 최초로그인 성공 시 NULL로 UPDATE 수행

### 2. 사업자정보( PTN_INFOS ) : 사업자 정보

#### 1-1) 사용자구분코드( USER_GBN_CD )

- NOR(일반유저) : 가게등록 및 이벤트 참여가능.
- PTN(사업자) : 이벤트 등록 및 참여가능
- ADM(관리자) : 사이트 관리가능

#### 1-2) 사업자코드 ( PTN_CD )

- 신규 사업자 등록 시 UPDATE , 최초 계정 등록시 NULL

#### 1-3) 로그인오류 횟수 ( LGN_ERR_CNT )

- 로그인 실패 시 CNT증가

- 로그인 성공 시 0으로 초기화

#### 1-4) 최종로그인 일시 ( LST_LGN_DATE )

- 로그인 5회이상 실패시 SYSDATE로 UPDATE

- 24시간이 지난 후 최초로그인 성공 시 NULL로 UPDATE 수행

### 2. 사업자정보 ( PTN_INFOS ) : 사업자 정보 테이블

**3. 이벤트정보( EVENT_INFOS ) : 이벤트 정보**  

- 이벤트 진행상태 ( 진행중: WORK, 종료:END )
- [ FK ] 이벤트 등록시 로그인 사업자계정의 사업자코드 참조 함.
- [ INDEX ] 사업자 별 매출을 조회할 수 있도록 PTN_CD,EVENT_SEQ로 INDEX를 구성 함.  

**4. 이벤트 참여이력 ( EVENT_HIST ) : 고객별 참여이벤트이력을 등록.**  

- 참여상태 ( 결제완료 : COM, 취소 : CAN, 취소 후 다시결제 : REDO )
- 리뷰여부 ( 리뷰작성 한 경우: Y, 작성 안 한 경우 : N , 이때 N은 Default 값 )
- [ FK ] 이벤트 가 종료(END)되었을 때 참여 한 계정의 ID와,등록 한 사업자 코드, 종료 된 이벤트 번호를 참조 함
- [ INDEX ] 이벤트 별 리뷰를 조회할 수 있도록 EVENT_SEQ, REVIEW_SEQ로 INDEX를 구성 함.  

**5. 리뷰정보 ( REVIEW_INFOS ) : 리뷰정보**  

**6. 메뉴 ( MENU_LIST ) : 계정의 사용자구분코드에 따른 메뉴구성**  

- 일반(NOR) : 리뷰등록, 개인정보수정
- 사업자(PTN) : 리뷰등록, 이벤트등록, 가게정보수정
- 관리자(ADM) : 메뉴관리 가능
- 공통(COM) : 비 로그인시 기본 메뉴

## 주요 기능

**1. 등록화면**

- 계정등록시 PW 암호화 ( SHA-256 )
- 사진 업로드기능
- 동네 정보 등록 시 다음 주소 API 활용
- Ajax를 활용한 ID중복체크

**2. 로그인**  

- 유효성 체크
- 비밀번호 3회 이상 실패 시 캡챠화면 구현

**3. 메인페이지**  

- 최근 이벤트 목록3 건 조회
- 최초 접속 시 최근 등록리뷰 3건 조회 ( 동네와 상관없이 )
- 동네 검색 시 동네의 최근 이벤트 3건 조회 ( 1건도 없으면 alert 이후에 default 이미지 )  

**4. 이벤트**  

- 사업자등록이 되어있는 계정만 등록 가능
- 이벤트 등록 시 이미지 업로드 ( 없으면 default 이미지 )
- 이벤트 상세목록 조회, 삭제, 등록  

## 개발내역

