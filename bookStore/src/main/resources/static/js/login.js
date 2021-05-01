document.addEventListener('DOMContentLoaded', function() {

	$('.alert').hide();
	$('.alert').empty();
	document.querySelector('#submit').addEventListener('click', () => load_login());
	
});

function load_login(){
	
	let userData;
	let username = $('#username').val();
	let password = $('#password').val();
	
	userData = {
		username : username,
		password : password
	}
	
	$.ajax({
		type: "POST",
		data: userData,
		url: "/bookstore/login",
		success: function( result ){
		
			$('.alert').hide();
			$('.alert').empty();
			
			if( result === true ){
				$('#form').attr( 'action', "/bookstore/search" );
				$('#form').submit();
			} 
			else {
				$('.alert').show();
				$('.alert').append('The account name or password that you have entered is incorrect.');
			}
			
		}
	});



};