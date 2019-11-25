<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<br>
	<div class="container" style="width: 25%; text-align: center;">
		<form method="post" action="/first/userInfos/login.do">
			<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
				<thead style ="text-align : center;">
					<tr>
						<th colspan="3">로그인</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;">아이디</td>
						<td><input class="form-control" type="text" id="userId" name="userId" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">비밀번호</td>
						<td><input class="form-control" type="password" id="userPw" name="userPw" maxLength="20"></td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="2"><input class="btn btn-primary pull-right" type="submit" value="로그인">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	
		<%
		String messageContent = null;
		if (session.getAttribute("messageContent") != null) {
			messageContent = (String)session.getAttribute("messageContent");
		}

		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String)session.getAttribute("messageType");
		}

		if (messageContent != null) {
	%>
	<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<div class="modal-content <%if (messageType.equals("error_message")) out.println("panel-warning"); else out.println("panel-success");%>">
				
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> 
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							<%=messageType%>
						</h4>
					</div>
					<div class="modal-body">
					<%=messageContent%>
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
	<script>
			$('#messageModal').modal("show"); 
	</script>
		<%
			session.removeAttribute("messageContent");
			session.removeAttribute("messageType");
			}
		%>

</body>
</html>