  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>

	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="/main/start.do">우리동네이벤트</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>
			
			<h1>로그인 세션의 userGbnCd 값 ! : ${login.userGbnCd}</h1>

<!-- 			<div class="collapse navbar-collapse" id="ftco-nav"> -->
<!-- 				<ul class="navbar-nav ml-auto"> -->
<%-- 					<c:forEach var="row" items="${menuList}"> --%>
<%-- 						<li class="nav-item"><a href=${ row.servletHref } class="nav-link">${ row.menuNm }</a></li> --%>
<%-- 					</c:forEach> --%>
<!-- 				</ul> -->
<!-- 			</div> -->

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/com/contact.do" class="nav-link">About</a></li>
				</ul>
			</div>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/com/contact.do" class="nav-link">Contact</a></li>
				</ul>
			</div>
			
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/com/loginPage.do" class="nav-link">Login</a></li>
				</ul>
			</div>
			
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/com/userRegistGo.do" class="nav-link">SignUp</a></li>
				</ul>
			</div>
			
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/nor/selectEventInfos.do" class="nav-link">Events</a></li>
				</ul>
			</div>
			
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/com/logout.do" class="nav-link">Logout</a></li>
				</ul>
			</div>
						
		</div>
	</nav>
</body>
</html>