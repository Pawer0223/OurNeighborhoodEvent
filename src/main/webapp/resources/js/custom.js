	function loginBox() {

		var userId = false;
		
		
		
		
		
	}
	
	$(function(){
	    $('.loginBox').click(function(){
	        $('.loginBox').hide();
	    });
	});

	function passwordCheckFunction() {

		var pw1 = $('#userPw').val();
		var pw2 = $('#userPw2').val();

		if (pw1 != pw2) {
			$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
		} else {
			$('#passwordCheckMessage').html('');
		}

	}
