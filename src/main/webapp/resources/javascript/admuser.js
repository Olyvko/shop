 $( document ).ready(function() {
	  var basePath = document.getElementsByTagName('base')[0].href;
	  $.ajax({
			type: "GET",
			url: '/admin/users',  
			data: {}, 
			dataType : "json",                    
			success: function (data, textStatus) { 
				var orderNode = document.getElementById('mod-user-list').childNodes[1].cloneNode(true);
				var tbodyNode = orderNode.childNodes[3].childNodes[1].childNodes[3];
				var boxContent = document.getElementById('content');
				
				data.forEach(function(dateElem) {
					var userNode = document.getElementById('mod-user-info').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
					userNode.childNodes[1].innerHTML = dateElem.id;
					userNode.childNodes[3].innerHTML = dateElem.login;
					userNode.childNodes[5].innerHTML = dateElem.firstname+" "+dateElem.lastname;
					userNode.childNodes[7].innerHTML = dateElem.address;
					var imgActive="";
						imgActive = "background:  url('"+"/resources/images/image/"+dateElem.active+".png')";
						
					userNode.childNodes[9].childNodes[0].childNodes[0].setAttribute('style',imgActive+" center center no-repeat; display: inline-block; width: 24px;height: 24px;");
					userNode.childNodes[9].childNodes[0].setAttribute('href',dateElem.active);
					tbodyNode.appendChild(userNode);
				});
				boxContent.appendChild(orderNode);	
		    } 
		});

	  $(document).on("click","#status_change",function(e){
			e.preventDefault();
			if($(this).attr('href')=="true")
				var status = Boolean("true");
		    else
				var status = Boolean("");
			var id = e.target.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			 $.ajax({
					type: "POST",
					url: '/admin/user',  
					data: {"id":id,"status":!status}, 
					dataType : "json",                    
					success: function (data, textStatus) { 

						imgActive = "background:  url('"+"/resources/images/image/"+!status+".png')";
						e.target.parentNode.setAttribute('href',!status);
						e.target.setAttribute('style',imgActive+" center center no-repeat; display: inline-block; width: 24px;height: 24px;");
						
				    } 
				});
			
				
		});
	  
  });

 function formSubmit() {
 	document.getElementById("logoutForm").submit();
 } 