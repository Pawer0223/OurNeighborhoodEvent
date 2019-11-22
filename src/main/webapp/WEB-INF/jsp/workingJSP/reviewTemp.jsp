<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700,800,900&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="/first/resources/mainPage/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/first/resources/mainPage/css/animate.css">

<link rel="stylesheet"
	href="/first/resources/mainPage/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/first/resources/mainPage/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="/first/resources/mainPage/css/magnific-popup.css">

<link rel="stylesheet" href="/first/resources/mainPage/css/aos.css">

<link rel="stylesheet"
	href="/first/resources/mainPage/css/ionicons.min.css">

<link rel="stylesheet"
	href="/first/resources/mainPage/css/bootstrap-datepicker.css">
<link rel="stylesheet"
	href="/first/resources/mainPage/css/jquery.timepicker.css">


<link rel="stylesheet" href="/first/resources/mainPage/css/flaticon.css">
<link rel="stylesheet" href="/first/resources/mainPage/css/icomoon.css">
<link rel="stylesheet" href="/first/resources/mainPage/css/style.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

</head>
<body>

	<section class="ftco-section testimony-section">

		<div class="container">

			<div class="row justify-content-center mb-5">
				<div class="col-md-7 text-center heading-section ftco-animate">
					<span class="subheading">Service Review</span>
					<h2 class="mb-3">Happy Clients</h2>
				</div>
			</div>

			<div class="row ftco-animate">

				<div class="col-md-12">
					<div class="carousel-testimony owl-carousel ftco-owl">

						<c:choose>
							<c:when test="${fn:length(latestReviews) > 0}">
								<c:forEach items="${latestReviews}" var="row">

									<div class="item">
										<div class="testimony-wrap py-4">
											<div class="text">
												<p class="mb-4">${ row.REVIEW_DESC }</p>
												<div class="d-flex align-items-center">
													<div class="user-img"
														style="background-image: url(${ row.PROFILE_PIC })"></div>
													<div class="pl-3">
														<p class="name">${ row.USER_NM }</p>
														<span class="position">${ row.EVENT_NM }</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								조회된 결과가 없습니다.
							</c:otherwise>
						</c:choose>


					</div>
				</div>
			</div>
		</div>
	</section>

	<table style="border: 1px solid #ccc">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="15%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">이벤트 seq</th>
				<th scope="col">파트너 명</th>
				<th scope="col">이미지링크</th>
				<th scope="col">원 가격</th>
				<th scope="col">이벤트 가격</th>
				<th scope="col">수량</th>
				<th scope="col">동네</th>
				<th scope="col">배달가능여부</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(latestEvents) > 0}">
					<c:forEach items="${latestEvents}" var="row">
						<tr>
							<td>${ row.EVENT_SEQ }</td>
							<td>${ row.PTN_NM }</td>
							<td>${ row.PRODUCT_PIC }</td>
							<td>${ row.ORIGIN_PRICE }</td>
							<td>${ row.EVENT_PRICE }</td>
							<td>${ row.AMOUNT }</td>
							<td>${ row.NEIGHBOR }</td>
							<td>${ row.DELIVERY_YN }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>



	<script src="/first/resources/mainPage/js/jquery.min.js"></script>
	<script src="/first/resources/mainPage/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/first/resources/mainPage/js/popper.min.js"></script>
	<script src="/first/resources/mainPage/js/bootstrap.min.js"></script>
	<script src="/first/resources/mainPage/js/jquery.easing.1.3.js"></script>
	<script src="/first/resources/mainPage/js/jquery.waypoints.min.js"></script>
	<script src="/first/resources/mainPage/js/jquery.stellar.min.js"></script>
	<script src="/first/resources/mainPage/js/owl.carousel.min.js"></script>
	<script src="/first/resources/mainPage/js/jquery.magnific-popup.min.js"></script>
	<script src="/first/resources/mainPage/js/aos.js"></script>
	<script src="/first/resources/mainPage/js/jquery.animateNumber.min.js"></script>
	<script src="/first/resources/mainPage/js/bootstrap-datepicker.js"></script>
	<script src="/first/resources/mainPage/js/jquery.timepicker.min.js"></script>
	<script src="/first/resources/mainPage/js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="/first/resources/mainPage/js/google-map.js"></script>
	<script src="/first/resources/mainPage/js/main.js"></script>

</body>
</html>