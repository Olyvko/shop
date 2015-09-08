$(document).ready(function() {
	 var basePath = document.getElementsByTagName('base')[0].href;
		$(document).on("click","#createUser",function(e){
			// Create new user
			if ($('#firstname').val() == ''
				||$('#username').val() == ''
					||$('#email').val() == ''
						||$('#password').val() == ''
							||$('#confirm').val() == ''
								||$('#address').val() == ''||$('#password').val() != $('#confirm').val()) {
				$('#notification').html('<div class="warning" style="display: none;">Enter correct all fields!!!</div>');
				$('.warning').fadeIn('slow');
				setTimeout(close, 3000);
				return;
			} 
			$.ajax({
				type: "POST",
				url: '/user/create',  
				data: {"id":'',
					   "firstname":$('#firstname').val(),
					   "lastname":$('#username').val(),
					   "email":$('#email').val(),
					   "login":$('#email').val(),
					   "password":$('#password').val(),
					   "confirmPassword":$('#confirm').val(),
					   "active":1,
					   "photo":"foto",
					   "address":$('#address').val()}, 
				dataType : "json",                    
				success: function (data, textStatus) {
					if(data){
						document.getElementById('formUserExist').click();
						$('#notification').html('<div class="success" style="display: none;">Welcome '+data.lastname+' on our Website!</div>');
						$('.success').fadeIn('slow');
						setTimeout(close, 3000);
						
					}else{
						$('#notification').html('<div class="warning" style="display: none;">Failed to register!</div>');
						$('.warning').fadeIn('slow');
					}	
			    } 
			});
			
		});
		$(document).on("click","#formUserAdd",function(e){

			document.getElementById("goLoginNew").removeAttribute("hidden");
			document.getElementById("goLoginExist").setAttribute('hidden',"false");
			
		});

		$(document).on("click","#formUserExist",function(e){
			
			document.getElementById("goLoginExist").removeAttribute("hidden");
			document.getElementById("goLoginNew").setAttribute('hidden',"false");
			
		});
		
	  });


function delDomChild(element){
	  	while (element.firstChild) {
	  		  element.removeChild(element.firstChild);
	  		}
	  }

var close = function() {
	delDomChild(document.getElementById("notification"));
}	