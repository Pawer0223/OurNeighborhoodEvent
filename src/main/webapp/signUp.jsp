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

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/first/resources/js/boostrap.js"></script>

</head>
<body>

	<div class="container">

		<!-- 변경 고려사항 1 -->
		<form method="post" action="./userRegister">

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
						<td style="width: 110px;"><button class="btn btn-primary" onclick="registerCheckFunction();">중복체크</button></td>
					</tr>
					<tr>
						<td style="width: 110px;">비밀번호</td>
						<td colspan="2"><input class="form-control" type="password" id="password1" name="password1" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">비밀번호 확인</td>
						<td colspan="2"><input class="form-control" type="password" id="password2" name="password2" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">이메일</td>
						<td colspan="2"><input class="form-control" type="email" id="email" name="email" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">프로필 사진</td>
						<td colspan="2"><input class="form-control" type="password" id="password1" name="password1" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">휴대폰번호</td>
						<td colspan="2"><input class="form-control" type="password" id="password1" name="password1" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">동네</td>
						<td colspan="2"><input class="form-control" type="password" id="password1" name="password1" maxLength="20"></td>
					</tr>
					<tr>
						<td style="text-align : left" colspan="3"><input class="btn btn-primary pull-right" type="submit" value="회원가입"></td>
					</tr>



				</tbody>

			</table>


		</form>



	</div>

</body>
</html>