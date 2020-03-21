<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>검색어정보</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div align="center">
		<br> <br>


		<h3>검색어정보</h3>

		<c:forEach items="${jusos}" var="row" varStatus="status">

			<table border="1">
				<tr>
					<th>detBdNmList</th>
					<th>engAddr</th>
					<th>rn</th>
					<th>emdNm</th>
					<th>zipNo</th>
					<th>roadAddrPart2</th>
					<th>emdNo</th>
					<th>sggNm</th>
					<th>jibunAddr</th>
					<th>siNm</th>
					<th>roadAddrPart1</th>
					<th>bdNm</th>
					<th>admCd</th>
					<th>udrtYn</th>
					<th>lnbrMnnm</th>
					<th>roadAddr</th>
					<th>lnbrSlno</th>
					<th>buldMnnm</th>
					<th>bdKdcd</th>
					<th>liNm</th>
					<th>rnMgtSn</th>
					<th>mtYn</th>
					<th>bdMgtSn</th>
					<th>buldSlno</th>
				</tr>
				<tr>
					<th>${detBdNmList}</th>
					<th>${engAddr}</th>
					<th>${rn}</th>
					<th>${emdNm}</th>
					<th>${zipNo}</th>
					<th>${roadAddrPart2}</th>
					<th>${emdNo}</th>
					<th>${sggNm}</th>
					<th>${jibunAddr}</th>
					<th>${siNm}</th>
					<th>${roadAddrPart1}</th>
					<th>${bdNm}</th>
					<th>${admCd}</th>
					<th>${udrtYn}</th>
					<th>${lnbrMnnm}</th>
					<th>${roadAddr}</th>
					<th>${lnbrSlno}</th>
					<th>${buldMnnm}</th>
					<th>${bdKdcd}</th>
					<th>${liNm}</th>
					<th>${rnMgtSn}</th>
					<th>${mtYn}</th>
					<th>${bdMgtSn}</th>
					<th>${buldSlno}</th>
				</tr>
				<br>
			</table>

		</c:forEach>


		<br> <br> <a class="btn btn-outline-success" href="/goHome">홈
			화면으로가기</a><br> <br> <br> <br>
	</div>
</body>
</html>