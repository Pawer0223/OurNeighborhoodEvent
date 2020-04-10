<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="/com/start.do">Woo Dong 2</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span>
		</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<!--비로그인 사용자한테만 Login 메뉴가 보인다.  -->
					<sec:authorize access="isAnonymous()">
						<li class="nav-item"><a href="/com/loginPage.do" class="nav-link">Login</a></li>
					</sec:authorize>
					<!-- 나의 정보는 일반사용자, 파트너에게 보인다.  -->
					<sec:authorize access="hasAnyRole('ROLE_NORMAL', 'ROLE_PARTNER')">
						<li class="nav-item"><a href="/nor/myInfoPage.do" class="nav-link">My Info</a></li>
					</sec:authorize>
					<!-- 리뷰등록은 일반,파트너 에게만 보인다.  -->
					<sec:authorize access="hasAnyRole('ROLE_NORMAL', 'ROLE_PARTNER')">
						<li class="nav-item"><a href="/nor/goRegistReview.do" class="nav-link">Regist Review</a></li>
					</sec:authorize>
					<!-- 가게 등록은, 사업자 등록하지않은 일반 사용자에게만 보인다.  -->
					<sec:authorize access="hasRole('ROLE_NORMAL')">
						<sec:authorize access="!hasRole('ROLE_PARTNER')">
							<li class="nav-item"><a href="/nor/goRegistStore.do" class="nav-link">Regist Store</a></li>
						</sec:authorize>
					</sec:authorize>
					<!-- 이벤트 등록은 파트너만 할 수 있다.  -->
					<sec:authorize access="hasRole('ROLE_PARTNER')">
						<li class="nav-item"><a href="/ptn/registEventPage.do" class="nav-link">Regist Event</a></li>
					</sec:authorize>
					<!--로그인 사용자한테만 Logout 메뉴가 보인다.  -->
					<sec:authorize access="isAuthenticated()">
						<li class="nav-item"><a href="/com/logout.do" class="nav-link">Logout</a></li>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<li class="nav-item"><a href="/com/userRegistGo.do" class="nav-link">SignUp</a></li>
					</sec:authorize>
				</ul>
			</div>
	</div>
</nav>
</body>
</html>