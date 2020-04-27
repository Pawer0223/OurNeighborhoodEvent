## KaKao OPEN API 사용하여 주소 검색 및 지도범위의 이벤트 조회

- 가게 등록 시 주소정보 조회
- 이벤트 조회 시 조회 범위안의 이벤트 조회 ( 위도,경도로 구분 )
- 이벤트 등록 시 등록가게의 위도,경도 정보 참조

### 관련 소스코드 ( 진행 중 )
- 호출 controller - getAddrApiKaKao.do 수행 <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/woodong2/controller/common/CommonController.java">[ 링크 ]</a>
- API연동 및 데이터 받아오기. <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/woodong2/utilities/function/APICommons.java">[ 링크 ]</a>
- 연동 데이터 Parse <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/woodong2/utilities/function/APIParse.java">[ 링크 ]</a>

### 결과확인 ( 진행 중 )

- 주소검색 ( AutoComplete )
- 이벤트 검색 시 

![kakaoAPI](../readmeSource/gif/kakao_api.gif)
