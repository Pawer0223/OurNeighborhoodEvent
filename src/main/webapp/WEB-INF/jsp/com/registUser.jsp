<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SignUp</title>

<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/mapAPI.js"></script>
<script src="/resources/js/validation.js"></script>


<script type ="text/javascript">

	function registerCheckFunction(){
		
		$(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader( "${_csrf.headerName}", "${_csrf.token}" );
		});

		var userId = $('#userId').val();
		
		var flag = checkIdValidation();
		
		if ( !flag ) return;
		
		$.ajax({
			type : "POST",
			url : '/com/duplicateCheck.do' ,
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
	
</script>

</head>
<body>
	<br>

	<div class="container" style="width: 40%; text-align: center; valign: center;">

		<form method="post" enctype="multipart/form-data" id="registUser" action="/com/userRegist.do?${_csrf.parameterName}=${_csrf.token}">

			<table class="table table-bordered table-hover" style="text-align: center; border: 0px solid #dddddd">
				<thead>
					<tr>
						<th style="text-align:center; border:0px;" colspan="3"><h2>회원가입</h2><br></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px; padding-top: 16px;">아이디</td>
						<td><input class="form-control" type="text" id="userId" name="userId" maxLength="20" placeholder="ID를 입력해 주세요"></td>
						<td style="width: 110px;"><button class="btn btn-primary" type="button" onclick="registerCheckFunction();">중복체크</button></td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 16px;">비밀번호</td>
						<td colspan="2"><input class="form-control" type="password" id="userPw" name="userPw" maxLength="20" onkeyup="passwordCheckFunction();" placeholder="pw를 입력해 주세요"></td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 21px;;">비밀번호 확인</td>
						<td colspan="2">
						<input class="form-control" type="password" id="userPw2" name="userPw2" maxLength="20" onkeyup="passwordCheckFunction();" placeholder="PW확인">
						<h5 style="color : red; text-align : left;" id="passwordCheckMessage"></h5>
						</td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 16px;">이메일</td>
						<td colspan="2"><input class="form-control" type="email" id="email" name="email" maxLength="20" placeholder="email@example.com"></td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 16px;">이름</td>
						<td colspan="2"><input class="form-control" type="text" id="userNm" name="userNm" maxLength="20" placeholder="이름"></td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 16px;">프로필 사진</td>
						<td colspan="2"><input class="form-control" type="file" id="pictureFile" name="pictureFile" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 16px;">휴대폰번호</td>
						<td colspan="2"><input class="form-control" type="tel" id="phoneNum" name="phoneNum" maxLength="20" placeholder="010-0000-0000"></td>
					</tr>
					<tr>
						<td style="width: 110px; padding-top: 16px;">동네</td>
						<td colspan="2"><input onclick="sample6_execDaumPostcode()" type="text" class="form-control" placeholder="click 동네를 검색해주세요" id="sample6_address" name="neighbor" readonly ></td>
					</tr>
					<tr>
						<td style="align:center;" colspan="3">
						<input class="btn btn-primary pull-right" type="button" onclick="checkValidation()" style="margin-left: 10px;" value="회원가입">
						<input class="btn btn-primary pull-right" type="reset" value="초기화">
						</td>
					</tr>
					<tr>
					<td colspan="3"><a href="/com/start.do">홈 화면으로 가기</a></td>
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
						<%
							if (messageType.equals("success")) {
						%>
							<a type="button" class="btn btn-primary" href="/com/start.do">홈으로</a>
						<%
							} else
						%><button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
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