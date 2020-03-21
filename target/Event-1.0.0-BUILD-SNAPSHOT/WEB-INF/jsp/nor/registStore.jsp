<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>가게등록</title>

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

		var bizrRegNo = $('#bizrRegNo').val();
		
		var flag = checkBizrRegNoValidation();
		
		if ( !flag ) return;
		
		$.ajax({
			type : "POST",
			url : '/nor/bizrNoDuplicateCheck.do' ,
			data : { bizrRegNo : bizrRegNo },
			success : function(result){
				if ( result == 1 ){
					$('#checkMessage').html('해당 사업자번호는 기등록된 정보입니다.');
					$('#checkType').attr('class' , 'modal-content panel-warning');
					$('#bizrRegNo').val('');
				}else{
					$('#checkMessage').html('사용할 수 있는 사업자정보입니다.');
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

	<div class="container" style="width: 55%; text-align: center;">

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
						<td><input class="form-control" type="number" id="bizrRegNo" name="bizrRegNo"  maxlength="10" placeholder ="-를 제외한 10자리 입력해주세요" oninput="checkFlagChange(this);"></td>
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
						<td style="width: 110px;">FAX</td>
						<td colspan="2"><input class="form-control" type="text" id="faxNo" name="faxNo" maxLength="20" placeholder="FAX번호를 입력해 주세요, 없으면 공백"></td>
					</tr>
					<tr>
						<td style="width: 110px;">동네</td>
						<td colspan="2"><input onclick="sample7_execDaumPostcode()"
							type="text" class="form-control" placeholder="click 동네를 검색해주세요"
							id="sample6_address" name="neighbor" readonly ></td>
					</tr>
					<tr>
						<td style="width: 110px;">우편번호</td>
						<td colspan="2"><input type="text" class="form-control" placeholder="상단의 동네를 검색해주세요"
							id="sample6_postcode" name="addNo" readonly ></td>
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