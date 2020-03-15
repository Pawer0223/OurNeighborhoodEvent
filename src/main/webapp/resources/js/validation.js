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

function checkFlagChange(){
	duplicateCheck = false;
}

function checkValidation(){
	
	var userId = $('#userId').val();
	var userPw = $('#userPw').val();
	var userPw2 = $('#userPw2').val();
	var email = $('#email').val();
	var userNm = $('#userNm').val();
	var phoneNum = $('#phoneNum').val();
	var sample6_address = $('#sample6_address').val();
	
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
	}else if ( sample6_address == "" ){
		$('#checkMessage').html('주소를 입력해 주세요.');
		$('#checkType').attr('class' , 'modal-content panel-warning');
		$('#checkModal').modal("show"); 
		return false;	
	}else{
		$('#registUser').submit();
	}
	
	
	
}