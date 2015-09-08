  $( document ).ready(function() {

	  var basePath = document.getElementsByTagName('base')[0].href;
		$.ajax({
			type: "GET",
			url: '/order/products',  
			data: {}, 
			dataType : "json",                    
			success: function (data, textStatus) { 
				var orderNode = document.getElementById('mod-order-cart').childNodes[1].cloneNode(true);
				var boxContent = document.getElementById('content');
				var boxTbody = document.getElementById('tbodyCart');
				if(data){

					data.forEach(function(dateElem) {

						var tbodyNode = document.getElementById('mod-order-cart-product').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
						tbodyNode.childNodes[1].childNodes[1].setAttribute('href',"/resources/images/data/"+dateElem.productImage);
						tbodyNode.childNodes[1].childNodes[1].childNodes[0].setAttribute('src',"/resources/images/data/"+dateElem.productImage);
						tbodyNode.childNodes[1].childNodes[1].childNodes[0].setAttribute('alt',dateElem.productName);
						tbodyNode.childNodes[1].childNodes[1].childNodes[0].setAttribute('title',dateElem.productName);
						tbodyNode.childNodes[3].childNodes[1].innerHTML = dateElem.productName;
						tbodyNode.childNodes[5].innerHTML = dateElem.id;
						tbodyNode.childNodes[7].innerHTML = dateElem.productPrice;
						orderNode.childNodes[3].childNodes[1].childNodes[3].appendChild(tbodyNode);
					
					});
				}else{
					$('#notification').html('<div class="warning" style="display: none;"> No products in cart</div>');
					$('.warning').fadeIn('slow');
					setTimeout(close, 3000);
				}	
				boxContent.appendChild(orderNode);		
			
		    } 
		});
	  
//Get all user order
	$(document).on("click","#historyOrder",function(e){
		e.preventDefault();
		delDomChild(document.getElementById("content"));	
		  $.ajax({
				type: "GET",
				url: '/order',  
				data: {}, 
				dataType : "json",                    
				success: function (order, textStatus) { 
					var orderNode = document.getElementById('mod-order-table').childNodes[1].cloneNode(true);
					var boxContent = document.getElementById('content');
					var boxTbody = document.getElementById('tbodyOrder');

					if(order){				
						order.forEach(function(dateElem) {
							var tbodyNode = document.getElementById('mod-order').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
							tbodyNode.childNodes[1].childNodes[1].innerHTML = dateElem.orderName;
							tbodyNode.childNodes[3].innerHTML = new Date(dateElem.orderDate).yyyymmdd();
							
							orderNode.childNodes[3].childNodes[1].childNodes[3].appendChild(tbodyNode);
						
						});
					}else{
						$('#notification').html('<div class="warning" style="display: none;">  No products in cart</div>');
						$('.warning').fadeIn('slow');
						setTimeout(close, 3000);
					}	
					boxContent.appendChild(orderNode);
			}
		  });
	});
// Get all cart
	$(document).on("click","#cartOrder",function(e){
		e.preventDefault();
		delDomChild(document.getElementById("content"));	
		$.ajax({
			type: "GET",
			url: '/order/products',  
			data: {}, 
			dataType : "json",                    
			success: function (data, textStatus) { 
				var orderNode = document.getElementById('mod-order-cart').childNodes[1].cloneNode(true);
				var boxContent = document.getElementById('content');
				var boxTbody = document.getElementById('tbodyCart');
				if(data){

					data.forEach(function(dateElem) {

						var tbodyNode = document.getElementById('mod-order-cart-product').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
						tbodyNode.childNodes[1].childNodes[1].setAttribute('href',"/resources/images/data/"+dateElem.productImage);
						tbodyNode.childNodes[1].childNodes[1].childNodes[0].setAttribute('src',"/resources/images/data/"+dateElem.productImage);
						tbodyNode.childNodes[1].childNodes[1].childNodes[0].setAttribute('alt',dateElem.productName);
						tbodyNode.childNodes[1].childNodes[1].childNodes[0].setAttribute('title',dateElem.productName);
						tbodyNode.childNodes[3].childNodes[1].innerHTML = dateElem.productName;
						tbodyNode.childNodes[5].innerHTML = dateElem.id;
						tbodyNode.childNodes[7].innerHTML = dateElem.productPrice;
						orderNode.childNodes[3].childNodes[1].childNodes[3].appendChild(tbodyNode);
					
					});
				}else{
					$('#notification').html('<div class="warning" style="display: none;">  No products in cart</div>');
					$('.warning').fadeIn('slow');
					setTimeout(close, 3000);
				}	
				boxContent.appendChild(orderNode);		
			
		    } 
		});
		 
	});
	
	//Add new order
	$(document).on("click","#addOrder",function(e){
		e.preventDefault();
		 $.ajax({
				type: "POST",
				url: '/order',  
				data: {}, 
				dataType : "json",                    
				success: function (data, textStatus) { 
				$('#notification').html('<div class="success" style="display: none;">'+data[0]+'</div>');
				$('.success').fadeIn('slow');
				setTimeout(close, 3000);
				document.getElementById('historyOrder').click();
				} 
			});
		 
	});

  });

  var close = function() {
  	delDomChild(document.getElementById("notification"));
  }	
  Date.prototype.yyyymmdd = function() {
	   var yyyy = this.getFullYear().toString();
	   var mm = (this.getMonth()+1).toString(); // getMonth() is zero-based
	   var dd  = this.getDate().toString();
	   return yyyy+ "-" + (mm[1]?mm:"0"+mm[0])+ "-" + (dd[1]?dd:"0"+dd[0]); // padding
	  };

  function delDomChild(element){
  	while (element.firstChild) {
  		  element.removeChild(element.firstChild);
  		}
  }