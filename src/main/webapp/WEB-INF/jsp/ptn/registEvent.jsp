<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>이벤트 등록</title>

<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/custom.js"></script>

</head>
<body>
	<br>

	<div class="container" style="width: 55%; text-align: center;">

		<form method="post" enctype="multipart/form-data" id="registEvent" action="/ptn/registEventInfos.do?${_csrf.parameterName}=${_csrf.token}">

			<table class="table table-bordered table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3">이벤트 등록</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;">제목</td>
						<td colspan="2"><input class="form-control" type="text" id="eventNm" name="eventNm" maxLength="20"></td>
					</tr>					
					<tr>
						<td style="width: 110px;">내용</td>
						<td colspan="2"><textarea class="form-control"  id="eventDesc" name="eventDesc" style="height: 350px;"
							placeholder="이벤트 내용"></textarea></td>
					</tr>
					<tr>
						<td style="width: 110px;">상품</td>
						<td colspan="2">
						<input class="form-control" type="text" id="product" name="product" maxLength="20" placeholder="상품 명">
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">상품 사진</td>
						<td colspan="2"><input class="form-control" type="file" id="pictureFile" name="pictureFile" maxLength="20"></td>
					</tr>
					<tr>
						<td style="width: 110px;">원 가격</td>
						<td colspan="2">
						<input class="form-control" type="text" id="originPrice" name="originPrice" maxLength="20" placeholder="상품 원 가격">
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">행사 가격</td>
						<td colspan="2">
						<input class="form-control" type="text" id="eventPrice" name="eventPrice" maxLength="20" placeholder="행사 가격">
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">수량</td>
						<td colspan="2">
						<input class="form-control" type="number" id="amount" name="amount" min="0" max="999" maxLength="20" placeholder="수량 제한 없을시  공백">
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">배달가능 여부</td>
						<td><input type="radio" id="deliveryYn" name="deliveryYn" value="Y">배달 가능</td>
						<td><input type="radio" id="deliveryYn" name="deliveryYn" value="N" checked="checked">배달 불 가능</td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="3">
						<input class="btn btn-primary pull-right" type="button" value="이벤트 등록" onclick="checkEventValidation();">
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
						<a type="button" class="btn btn-primary" href="/com/start.do">확인</a>
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