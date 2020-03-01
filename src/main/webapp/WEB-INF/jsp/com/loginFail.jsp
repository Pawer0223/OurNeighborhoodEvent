<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>

<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="woodong2.vo.common.UserInfos" %>

<%
	String name = "";
	String msg = (String) request.getAttribute("exceptionMsgName");
	
	if (msg == null || msg.equals("")) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		try {
			Object principal = auth.getPrincipal();
			if (principal instanceof UserInfos)
				System.out.println(" Accout 객체 맞음 !! ");
			else
				System.out.println(" Accout 객체 아님.. " + principal.getClass().toString());

			if (principal != null && principal instanceof UserInfos) {
				name = ((UserInfos) principal).getUsername();
				System.out.println(" Account에서 가지고온 이름 ! : " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<%-- 	<c:if test="${not empty exceptionMsgName}"> --%>
		<br>
		<font color="red">
			<p>에러 메시지 getAttribute !!! [ ${exceptionMsgName} ]
			     에러 메시지 sessionScope !!! [ ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} ]
			</p>
		</font>
<%-- 	</c:if> --%>
</body>
</html>