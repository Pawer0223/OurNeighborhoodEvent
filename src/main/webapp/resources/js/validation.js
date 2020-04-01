var duplicateCheck = false;

function passwordCheckFunction() {

	var pw1 = $('#userPw').val();
	var pw2 = $('#userPw2').val();

	if (pw1 != pw2) {
		$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
	} else {
		$('#passwordCheckMessage').html('');
	}

}

function checkIdValidation(){
	
	var userId = $('#userId').val();
	
	if ( userId == "" ){
		$('#checkMessage').html('ID를 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}
	
	duplicateCheck = true;
	
	return true;
	
}

function checkBizrRegNoValidation(){
	
	var bizrRegNo = $('#bizrRegNo').val();
	
	if ( bizrRegNo == "" ){
		$('#checkMessage').html('사업자등록번호를 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}
	
	duplicateCheck = true;
	
	return true;
	
}

function checkFlagChange(object){
	
	duplicateCheck = false;
	
	if( object != null ){
		if (object.value.length > object.maxLength){
		    object.value = object.value.slice(0, object.maxLength);
		}
	}
	
}

function checkUserValidation(){
	
	var userId = $('#userId').val();
	var userPw = $('#userPw').val();
	var userPw2 = $('#userPw2').val();
	var email = $('#email').val();
	var userNm = $('#userNm').val();
	var phoneNum = $('#phoneNum').val();
	
	if ( !duplicateCheck ){
		$('#checkMessage').html('ID중복체크를 해주세요 !');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}
	
	if ( userId == "" ){
		$('#checkMessage').html('ID를 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( userPw == "" ){
		$('#checkMessage').html('비밀번호를 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( userPw2 == "" ){
		$('#checkMessage').html('비밀번호확인을 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( userPw != userPw2 ){
		$('#checkMessage').html('입력비밀번호가 일치하지 않습니다.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( email == "" ){
		$('#checkMessage').html('이메일을 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( userNm == "" ){
		$('#checkMessage').html('이름을 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( phoneNum == "" ){
		$('#checkMessage').html('휴대폰번호를 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else{
		$('#registUser').submit();
	}
	
}

function checkReviewValidation(){
	
	var reviewName = $('#reviewName').val();
	var reviewDesc = $('#reviewDesc').val();
	
	if ( reviewName == "" ){
		$('#checkMessage').html('제목을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( reviewDesc == "" ){
		$('#checkMessage').html('내용을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else{
		$('#registReview').submit();
	}
}


function checkStoreValidation(){
	
	var bizrRegNo = $('#bizrRegNo').val();
	var ptnNm = $('#ptnNm').val();
	var rpstNm = $('#rpstNm').val();
	var rpstTel = $('#rpstTel').val();
	var sample6_address = $('#sample6_address').val();
	var sample6_postcode = $('#sample6_postcode').val();
	
	if ( bizrRegNo == "" ){
		$('#checkMessage').html('사업자 등록번호를 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( ptnNm == "" ){
		$('#checkMessage').html('상호 명을 입력해주세요');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( rpstNm == "" ){
		$('#checkMessage').html('대표자 명을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( rpstTel == "" ){
		$('#checkMessage').html('휴대번호를 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( sample6_address == "" ){
		$('#checkMessage').html('동네를 검색해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( sample6_postcode == "" ){
		$('#checkMessage').html('우편번호를 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}
	
	else{
		$('#registStore').submit();
	}
	
}

function checkEventValidation(){
	
	var eventNm = $('#eventNm').val();
	var eventDesc = $('#eventDesc').val();
	var product = $('#product').val();
	var pictureFile = $('#pictureFile').val();
	var originPrice = $('#originPrice').val();
	var eventPrice = $('#eventPrice').val();
	var amount = $('#amount').val();
	
	if ( eventNm == "" ){
		$('#checkMessage').html('제목을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( eventDesc == "" ){
		$('#checkMessage').html('내용을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( product == "" ){
		$('#checkMessage').html('상품명을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( pictureFile == "" ){
		$('#checkMessage').html('상품사진을 등록해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( originPrice == "" ){
		$('#checkMessage').html('원 금액을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( eventPrice == "" ){
		$('#checkMessage').html('행사금액을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else if ( amount == "" ){
		$('#checkMessage').html('수량을 입력해주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;
	}else{
		$('#registEvent').submit();
	}
	
}