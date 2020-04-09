<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	

<!DOCTYPE html>
<html>
<head>
<head>
<title>Woo Dong 2</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700,800,900&display=swap" rel="stylesheet"> -->

<link rel="stylesheet "href="/resources/mainPage/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/resources/mainPage/css/animate.css">

<link rel="stylesheet" href="/resources/mainPage/css/owl.carousel.min.css">
<link rel="stylesheet" href="/resources/mainPage/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/resources/mainPage/css/magnific-popup.css">

<link rel="stylesheet" href="/resources/mainPage/css/aos.css">

<link rel="stylesheet" href="/resources/mainPage/css/ionicons.min.css">

<link rel="stylesheet" href="/resources/mainPage/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/resources/mainPage/css/jquery.timepicker.css">

<link rel="stylesheet" href="/resources/mainPage/css/flaticon.css">
<link rel="stylesheet" href="/resources/mainPage/css/icomoon.css">
<link rel="stylesheet" href="/resources/mainPage/css/style.css">

<!-- jQuery 3.3.1 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>

	<%@ include file="header.jsp"%>
	
	<!-- 검색 창 -->
	<%@ include file="search.jsp"%>
	
	<!-- Our Services -->
	<%@ include file="section1.jsp"%>

	<!-- HOW TO USE -->
	<%@ include file="section2.jsp"%>
	
	<!-- 기획의도 -->
	<%@ include file="section3.jsp"%>


	<%
		String messageContent = null;

		if (session.getAttribute("messageContent") != null) {
			messageContent = (String) session.getAttribute("messageContent");
		}

		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String) session.getAttribute("messageType");

			if (messageType.equals("noSearchEvents")) {
				session.removeAttribute("messageType");
	%>
	<script type="text/javascript">
		alert("참여한 이벤트가 존재하지 않습니다.");
	</script>
	<%
		}
		}
	%>


	<%@ include file="footer.jsp"%>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>

	<!-- 	<script src="/resources/mainPage/js/jquery.min.js"></script>   -->
	<script src="/resources/mainPage/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/resources/mainPage/js/popper.min.js"></script>
	<script src="/resources/mainPage/js/bootstrap.min.js"></script>
	<script src="/resources/mainPage/js/jquery.easing.1.3.js"></script>
	<script src="/resources/mainPage/js/jquery.waypoints.min.js"></script>
	<script src="/resources/mainPage/js/jquery.stellar.min.js"></script>
	<script src="/resources/mainPage/js/owl.carousel.min.js"></script>
	<script src="/resources/mainPage/js/jquery.magnific-popup.min.js"></script>
	<script src="/resources/mainPage/js/aos.js"></script>
	<script src="/resources/mainPage/js/jquery.animateNumber.min.js"></script>
	<script src="/resources/mainPage/js/bootstrap-datepicker.js"></script>
	<script src="/resources/mainPage/js/jquery.timepicker.min.js"></script>
	<script src="/resources/mainPage/js/scrollax.min.js"></script>
<!-- 	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script> -->
<!-- 	<script src="/resources/mainPage/js/google-map.js"></script> -->
	<script src="/resources/mainPage/js/main.js"></script>

	<script src="/resources/js/custom.js"></script>
</body>
</html>