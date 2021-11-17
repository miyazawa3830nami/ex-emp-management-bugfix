'use strict';

$(function(){
	$('#touroku').on('click',function(){
		$('#touroku').prop('disabled',true);
		$('form').submit();
	})
	
	$(document).on('keyup', '#checkPassword', function(){
		let hostUrl = 'http://localhost:8080/check';
		let inputPass = $('#password').val();
		let inputCheckPass = $('#checkPassword').val();
		$.ajax({
			url:hostUrl,
			type:'POST',
			dataType:'json',
			data:{
				password:inputPass,
				checkPassword:inputCheckPass},
			async:true
		}).done(function(data){
			console.log(data);
			console.dir(JSON.stringify(data));
			$('#checkMessage').text(data.checkMessage);
		}).fail(function(XMLHttpRequest, textStatus, errorThrown){
			alert('エラーが発生しました');
			console.log('XMLHttpRequest:'+XMLHttpRequest.status);
			console.log('textStatus:'+textStatus);
			console.log('errorThrown:'+errorThrown.message);
		})
	})
})