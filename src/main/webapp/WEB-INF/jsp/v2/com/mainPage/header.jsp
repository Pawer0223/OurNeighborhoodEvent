<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<!-- Navigation 2 -->
<nav class="pt-30 pb-30 bg-light lh-40 navigation_2">
	<div class="container px-xl-0">
		<div class="row align-items-center justify-content-between">
			<div class="col-xl-2 col-lg-3 text-center text-lg-left" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
				<a href="#" class="mr-20 link color-main f-24 bold">Woo Dong 2</a>
			<!-- body 부분 -->
			</div>
			<div class="col-xl-10 col-lg-9 d-flex flex-wrap align-items-center justify-content-center justify-content-md-between">
				<div class="mb-10 mb-md-0" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300">
					
					<sec:authorize access="hasRole('ROLE_NORMAL')">
					<div class="d-inline-block px-20 dropdown">
						<a href="#" class="link color-main  dropdown-toggle" id="navigation_2_dropdown_1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Regist</a>
						<div class="bg-light dropdown-menu" aria-labelledby="navigation_2_dropdown_1">
					
							<!-- 가게 등록은, 사업자 등록하지않은 일반 사용자에게만 보인다.  -->
							<sec:authorize access="!hasRole('ROLE_PARTNER')">
							<div><a href="#" class="link color-main ">Store</a></div>
							</sec:authorize>
							<!-- 리뷰등록은 일반,파트너 에게만 보인다.  -->
							<sec:authorize access="hasAnyRole('ROLE_NORMAL', 'ROLE_PARTNER')">
								<div><a href="#" class="link color-main ">Review</a></div>
							</sec:authorize>

							<!-- 이벤트 등록은 파트너만 할 수 있다.  -->
							<sec:authorize access="hasRole('ROLE_PARTNER')">
								<div><a href="#" class="link color-main ">Event</a></div>
							</sec:authorize>

						</div>
					</div>
					</sec:authorize>
					<a href="#" class="mx-15 link color-main ">Events</a>
					<a href="#" class="mx-15 link color-main ">About</a>
				</div>
				<div class="text-md-right" data-aos-duration="600" data-aos="fade-down" data-aos-delay="600">

					<!--비로그인 사용자한테만 Login 메뉴가 보인다.  -->
					<sec:authorize access="isAnonymous()">
						<a href="/com/v2/loginPage.do" class="mx-15 link color-main ">Login</a>
					</sec:authorize>
					
					<!-- 나의 정보는 일반사용자, 파트너에게 보인다.  -->
					<sec:authorize access="hasAnyRole('ROLE_NORMAL', 'ROLE_PARTNER')">
						<a href="#" class="mx-15 link color-main ">My Info</a>
					</sec:authorize>
					
					<!--로그인 사용자한테만 Logout 메뉴가 보인다.  -->
					<sec:authorize access="isAuthenticated()">
						<a href="/com/v2/logout.do" class="mx-15 btn sm color-main border-gray f-16">Logout</a>
					</sec:authorize>
					
					<sec:authorize access="isAnonymous()">
					<a href="/com/v2/userRegistGo.do" class="mx-15 btn sm color-main border-gray f-16">Sign Up</a>
					</sec:authorize>

				</div>
			</div>
		</div>
	</div>
</nav>
<!-- Content 1 -->


</html>