'use strict';

$(function(){
	$('#touroku').on('click',function(){
		$('#touroku').prop('disabled',true);
		$('form').submit();
	})
})