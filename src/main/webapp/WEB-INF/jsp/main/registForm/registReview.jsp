<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>리뷰 등록</title>

<link rel="stylesheet" href="/first/resources/css/bootstrap.css">
<link rel="stylesheet" href="/first/resources/css/custom.css">


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/first/resources/js/bootstrap.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<script type="text/javascript">
	var target = document.getElementById("selectBox");
	
	var selectedText = target.options[target.selectedIndex].text;
</script>

</head>
<body>
	<br>

	<div class="container" style="width: 55%; text-align: center;">

		<form method="post" enctype="multipart/form-data" action="/first/reviewInfos/registReviews.do">

			<table class="table table-bordered table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3">리뷰 등록</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;">참여한 이벤트</td>
						<td colspan="2">
						<select id = "eventSeq" name="eventSeq" >
								<c:forEach var="row" items="${participatedEvents}">
									<option style="width : 300px;" value="${ row.EVENT_SEQ }">${ row.EVENT_NM }</option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">제목</td>
						<td colspan="2"><input class="form-control" type="text" id="reviewName" name="reviewName" maxLength="20"></td>
					</tr>					
					<tr>
						<td style="width: 110px;">내용</td>
						<td colspan="2"><textarea class="form-control"  id="reviewDesc" name="reviewDesc" style="height: 350px;"
							placeholder="리뷰를 작성해 주세요"></textarea></td>
					</tr>
					<tr>
						<td style="width: 110px;">별점</td>
						<td colspan="2">
						  <input type="radio" name="stars" value="1" checked>★&nbsp;
						  <input type="radio" name="stars" value="2"> ★★&nbsp;
						  <input type="radio" name="stars" value="3"> ★★★&nbsp;
						  <input type="radio" name="stars" value="4"> ★★★★&nbsp;
						  <input type="radio" name="stars" value="5"> ★★★★★&nbsp;
						</td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="3">
						<input class="btn btn-primary pull-right" type="submit" value="리뷰 등록">
						</td>
					</tr>
					
					
					<tr>
					<td colspan="3"><a href="/first/main/start.do">홈 화면으로 가기</a></td>
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
					<a href="/first/main/start.do">홈 화면으로 가기</a><%}else%><%=messageContent%>
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