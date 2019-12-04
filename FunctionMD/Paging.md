## Events메뉴에서 9개씩 페이징처리

### 테이블의 이벤트 총 건수, 페이지당 보여질 건수로 조회순번 및 조회데이터 범위 추출

- ex) 총 건수 : 52, 페이지당 보여질 건수 : 9일때<br>
      => 최대 조회순번은 6, 조회순번3 클릭했을 때 19~27번째글이 보여져야 함.
      
- 페이징 처리를 위한 신규 클래스 추가<br>
: <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/first/actions/model/Paging.java">[ Paging.java ]</a>

- 수행쿼리
```
	<select id="selectEventInfos" parameterType="first.actions.model.Paging" resultMap="eventInfos">
		<![CDATA[	  
		SELECT EVENT_SEQ
			 , PTN_CD
			 , PTN_NM
			 , EVENT_NM
			 , PRODUCT
			 , PRODUCT_PIC
			 , ORIGIN_PRICE
			 , EVENT_PRICE
			 , AMOUNT
			 , EVENT_STATUS
			 , NEIGHBOR
			 , DELIVERY_YN
		FROM (
		    SELECT ROWNUM RN, A.* 
		        FROM (
		                SELECT * 
		                FROM EVENT_INFOS
		                WHERE EVENT_STATUS='WORK'
		                ORDER BY EVENT_SEQ DESC 
		                ) A
		        )
		WHERE RN BETWEEN #{start} AND #{end}
		]]>
	</select>
```

- jsp소스코드
```
  <div class="block-27">
    <ul>
      <c:if test="${paging.startPage != 1 }">
        <a href="/first/eventInfos/selectEventInfos.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
      </c:if>
      <c:forEach begin="${ paging.startPage }" end="${ paging.endPage }" var="p">
        <c:choose>
          <c:when test="${ p == paging.nowPage }">
            <li class="active"><span><a href="/first/eventInfos/selectEventInfos.do?nowPage=${ p }&cntPerPage=${paging.cntPerPage}">${ p }</a></span></li>
          </c:when>
          <c:when test="${p != paging.nowPage }">
            <li><a href="/first/eventInfos/selectEventInfos.do?nowPage=${ p }&cntPerPage=${paging.cntPerPage}">${ p }</a></li>
          </c:when>
        </c:choose>
      </c:forEach>
      <c:if test="${paging.endPage != paging.lastPage}">
        <a href="/first/eventInfos/selectEventInfos.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
      </c:if>
    </ul>
  </div>
```

### 결과확인

![paging](../readmeSource/gif/paging.gif)


