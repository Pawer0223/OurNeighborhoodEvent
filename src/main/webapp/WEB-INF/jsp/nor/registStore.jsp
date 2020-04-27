<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>가게등록</title>

<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">

<script src="/resources/js/bootstrap.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/mapAPI.js"></script>
<script src="/resources/js/custom.js"></script>


<!--검색어 자동완성을위해서 추가 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type ="text/javascript">

	function registerCheckFunction(){
		
		$(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader( "${_csrf.headerName}", "${_csrf.token}" );
		});

		var bizrRegNo = $('#bizrRegNo').val();
		
		var flag = checkBizrRegNoValidation();
		
		if ( !flag ) return;
		
		$.ajax({
			type : "POST",
			url : '/nor/bizrNoDuplicateCheck.do' ,
			data : { bizrRegNo : bizrRegNo },
			success : function(result){
				
				if ( result == 1 ){
					alert('해당 사업자번호는 기등록된 정보입니다.');
				}else{
					alert('사용할 수 있는 사업자정보입니다.');
				}
				$('#checkModal').modal("show"); 
			}
		})
	}
	
</script>

</head>
<body>
	<br>

	<div class="container" style="width: 30%; text-align: center;">

		<form method="post" id="registStore" action="/nor/registPtnInfos.do">

			<table class="table table-bordered table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3">가게등록</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;">사업자 등록번호</td>
						<td><input class="form-control" type="text" id="bizrRegNo" name="bizrRegNo"  maxlength="10" placeholder ="-를 제외한 10자리 입력해주세요" onkeyup="checkFlagChange(this);"></td>
						<td style="width: 110px;"><button class="btn btn-primary" type="button" onclick="registerCheckFunction();">중복체크</button></td>
					</tr>
					<tr>
						<td style="width: 110px;">상호 명</td>
						<td colspan="2"><input class="form-control" type="text" id="ptnNm" name="ptnNm" maxLength="20" placeholder ="상호명을 입력해 주세요"></td>
					</tr>
					<tr>
						<td style="width: 110px;">대표자 명</td>
						<td colspan="2"><input class="form-control" type="text" id="rpstNm" name="rpstNm" maxLength="20" placeholder="대표자 명을 입력해 주세요"></td>
					</tr>
					<tr>
						<td style="width: 110px;">대표자 휴대번호</td>
						<td colspan="2">
						<input class="form-control" type="tel" id="rpstTel" name="rpstTel" maxLength="11" placeholder="-를 제외한 휴대번호를 입력해주세요">
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">동네</td>
						<!-- 
							<td colspan="2"><input onclick="sample7_execDaumPostcode()" type="text" class="form-control" placeholder="click 동네를 검색해주세요" id="sample6_address" name="neighbor" readonly ></td>
 						-->
						<td colspan="2">
							<form action="#" method="post" id="searchForm">
								<input name="addressNm" id="addressNm" type="text" class="form-control" placeholder="동네를 검색해주세요""> 
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">우편번호</td>
						<td colspan="2" id="addressInfoParent"><input type="text" class="form-control" placeholder="상단의 동네를 선택해 주세요." id="zoneNo" name="zoneNo" readonly ></td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="3">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input class="btn btn-primary pull-right" type="button" onclick="checkStoreValidation();" value="가게등록">
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
	<script type="text/javascript">
		var messageContent = '<%=(String)session.getAttribute("messageContent")%>';
		alert(messageContent);
		window.location = '/com/start.do';
	</script>
	<%
		session.removeAttribute("messageContent");
		session.removeAttribute("messageType");
		}
	%>

</body>
</html>