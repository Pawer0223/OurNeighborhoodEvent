<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>이벤트 상세</title>
<meta charset="utf-8">
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
</head>
<body>

	<%@ include file="header.jsp"%>
	<!-- END nav -->

	<section class="hero-wrap hero-wrap-2 ftco-degree-bg js-fullheight"
		style="background-image: url('/first/resources/mainPage/resources/mainPage/images/bg_1.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate pb-5 text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.jsp">Home <i
								class="ion-ios-arrow-forward"></i></a></span> <span>Event Detail <i
							class="ion-ios-arrow-forward"></i></span>
					</p>
					<h1 class="mb-3 bread">Event Detail</h1>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-property-details">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="property-details">
						<div class="img"
							style="background-image: url(${ eventDetail.productPic });"></div>
						<div class="text text-center">
							<span class="subheading">${ eventDetail.ptnNm }</span>
							<h2>${ eventDetail.eventNm }</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 pills">
					<div class="bd-example bd-example-tabs">
						<div class="d-flex justify-content-center">
							<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">

								<li class="nav-item"><a class="nav-link" id="pills-manufacturer-tab" data-toggle="pill" href="#pills-manufacturer" role="tab" aria-controls="pills-manufacturer" aria-expanded="true">Description</a></li>
								<li class="nav-item"><a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review" role="tab" aria-controls="pills-review" aria-expanded="true">Review</a></li>
							</ul>
						</div>

						<div class="tab-content" id="pills-tabContent">

							<div class="tab-pane fade" id="pills-manufacturer" role="tabpanel" aria-labelledby="pills-manufacturer-tab">
								<p>${ eventDetail.eventDesc }</p>
							</div>

							<div class="tab-pane fade" id="pills-review" role="tabpanel" aria-labelledby="pills-review-tab">
								<div class="row">
									<div class="col-md-7">
										<c:choose>
											<c:when test="${fn:length(reviewDetail) > 0}">
												<c:forEach items="${reviewDetail}" var="row">
													<div class="review d-flex">
														<div class="user-img"
															style="background-image: url(/first/resources/mainPage/images/person_3.jpg)"></div>
														<div class="desc">
															<h4>
																<span class="text-left">${ row.USER_NM }
																	<p class="star">
																		<c:forEach begin="0" end="${ row.STARS -1 }">
																			<i class="ion-ios-star"></i>
																		</c:forEach>
																	</p>
																</span> <span class="text-right">${ row.REVIEW_NAME }</span>
															</h4>
															<p>${ row.REVIEW_DESC }</p>
														</div>
													</div>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<h3 align="center">등록된 리뷰가 존재하지 않습니다.</h3>
											</c:otherwise>
										</c:choose>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="footer.jsp"%>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>

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