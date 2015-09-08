 $( document ).ready(function() {
	 var basePath = document.getElementsByTagName('base')[0].href;
	  
		$.ajax({
			type: "GET",
			url: '/login/user',  
			data: {}, 
			dataType : "json",                    
			success: function (data, textStatus) { 
				if(data!=null)
					document.getElementById('welcome').innerHTML = "You are logged in as "+data.firstname+" (<a href=\"javascript:formSubmit()\">Sign out</a>)"
				else
					document.getElementById('welcome').innerHTML = "Welcome! You can <a href=\"/login/\">sign in</a> here."
					
			
		    } 
		});
	  

  });
  

	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}