<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SignUp</title>

<link rel="stylesheet" href="/first/resources/css/bootstrap.css">
<link rel="stylesheet" href="/first/resources/css/custom.css">


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/first/resources/js/bootstrap.js"></script>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/first/resources/js/mapAPI.js"></script>

<script type ="text/javascript">

	function registerCheckFunction(){
		
		var userId = $('#userId').val();
		
		$.ajax({
			type : "POST",
			url : '/first/userInfos/duplicateCheck.do' ,
			data : { userId : userId },
			success : function(result){
				if ( result == 1 ){
					$('#checkMessage').html('사용할 수 없는 아이디입니다.');
					$('#checkType').attr('class' , 'modal-content panel-warning');
				}else{
					$('#checkMessage').html('사용할 수 있는 아이디입니다.');
					$('#checkType').attr('class' , 'modal-content panel-success');
				}
				$('#checkModal').modal("show"); 
			}
		})
	}
	
	function passwordCheckFunction(){
		
		var pw1 = $('#userPw').val();
		var pw2 = $('#userPw2').val();
		
		if ( pw1 != pw2 ) {
			$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
		} else {
			$('#passwordCheckMessage').html('');
		}
		
	}
</script>

</head>
<body>
	<br>

	<div class="container" style="width: 55%; text-align: center;">

		<form method="post" action="/first/userInfos/userRegist.do">

			<table class="table table-bordered table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3">회원가입</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;">아이디</td>
						<td><input class="form-control" type="text" id="userId" name="userId" maxLength="20"></td>
						<td style="width: 110px;"><button class="btn btn-primary" type="button" onclick="registerCheckFunction();">중복체크</button></td>
					</tr>
					<tr>
						<td style="width: 110px;">비밀번호</td>
						<td colspan="2"><input class="form-control" type="password" id="userPw" name="userPw" maxLength="20" onkeyup="passwordCheckFunction();"></td>
					</tr>
					<tr>
						<td style="width: 110px;">비밀번호 확인</td>
						<td colspan="2">
						<input class="form-control" type="password" id="userPw2" name="userPw2" maxLength="20" onkeyup="passwordCheckFunction();">
						<h5 style="color : red; text-align : left;" id="passwordCheckMessage"></h5>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">이메일</td>
						<td colspan="2"><input class="form-control" type="email"
							id="email" name="email" maxLength="20"
							placeholder="jane.doe@example.com"></td>
					</tr>
					<tr>
						<td style="width: 110px;">이름</td>
						<td colspan="2"><input class="form-control" type="text"
							id="userNm" name="userNm" maxLength="20" placeholder="홍길동"></td>
					</tr>
					<tr>
						<td style="width: 110px;">프로필 사진</td>
						<td colspan="2"><input class="form-control" type="file"
							id="profilePic" name="profilePic" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">휴대폰번호</td>
						<td colspan="2"><input class="form-control" type="text"
							id="phoneNum" name="phoneNum" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">동네</td>
						<td colspan="2"><input onclick="sample6_execDaumPostcode()"
							type="text" class="form-control" placeholder="click 동네를 검색해주세요"
							id="sample6_address" name="neighbor" readonly ></td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="3">
						<input class="btn btn-primary pull-right" type="submit" value="회원가입">
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
					<%if (messageType.equals("success")){%>
					<a href="/first/userInfos/loginPage.do">로그인 하러가기</a><%}else%><%=messageContent%>
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
		
	<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<div id="checkType" class="modal-content panel-info">
				
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> 
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							확인 메시지
						</h4>
					</div>
					
					<div class="modal-body" id="checkMessage">
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>