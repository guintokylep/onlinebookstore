document.addEventListener('DOMContentLoaded', function() {

	$('.alert-danger').hide();
	$('.alert-success').hide();
	$('.alert-danger').empty();
	$('.alert-success').empty();
	document.querySelector('#submit').addEventListener('click', () => load_login());
	document.querySelector('#return').addEventListener('click', () => load_return());
	
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
		url: "/bookstore/register/save",
		success: function( result ){
		
			$('.alert-danger').hide();
			$('.alert-success').hide();
			$('.alert-danger').empty();
			$('.alert-success').empty();
			
			if( result[0] === "error" ){
				$('.alert-danger').show();
				$('.alert-danger').append(result[1]);
			}
			else {
				$('.alert-success').show();
				$('.alert-success').append(result[1]);
			}
			
		}
	});

};

function load_return(){
	 window.location.href = "/bookstore";
}