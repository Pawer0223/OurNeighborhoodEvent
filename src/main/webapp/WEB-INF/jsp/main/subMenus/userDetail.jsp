<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="first.actions.model.UserInfos"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>

<link rel="stylesheet" href="/first/resources/css/bootstrap.css">
<link rel="stylesheet" href="/first/resources/css/custom.css">


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/first/resources/js/bootstrap.js"></script>

<script type="text/javascript">
</script>

</head>
<body>
	
	<h1>바보</h1>
	
	<img src="${ login.profilePic }" width="500" height="500">
	
	<h1>컨텍스트 패스 : ${pageContext.request.contextPath}</h1>
	<h1>세션 값 1:  ${ login.profilePic }</h1>
	<h1>전체경로 : ${pageContext.request.contextPath}${ login.profilePic }</h1>
	
	<div class="user-img" style="background-image: url(${pageContext.request.contextPath}${ login.profilePic })"></div>

</body>
</html>