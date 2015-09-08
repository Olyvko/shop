
  $( document ).ready(function() {
	  var basePath = document.getElementsByTagName('base')[0].href;
	  $.ajax({
			type: "GET",
			url: '/category/',  
			data: {}, 
			dataType : "json",                    
			success: function (data, textStatus) { 
				document.getElementById("category-box").removeAttribute("hidden");
				document.getElementById("category-box").childNodes[1].innerHTML="Product catalog";
				var boxCategory = document.getElementById('box-category');
				var boxCategory2 = document.getElementById('box-product2');
				data.forEach(function(dateElem) {
					// Create leftside for categories
					var liNode = document.getElementById('mod-category-li').childNodes[1].cloneNode(true);
					liNode.childNodes[1].setAttribute('href',"/category/"+dateElem.id);
					liNode.childNodes[1].innerHTML = dateElem.categoryName;
					boxCategory.childNodes[1].appendChild(liNode);
					// Create content for categories with image
					var dCat2 = document.getElementById('mod-category-div').childNodes[1].cloneNode(true);
					dCat2.childNodes[1].childNodes[0].setAttribute('href',"/category/"+dateElem.id);
					dCat2.childNodes[1].childNodes[0].childNodes[0].setAttribute('src',"/resources/images/data/"+dateElem.categoryImagePath);
					dCat2.childNodes[1].childNodes[0].childNodes[0].setAttribute('title',dateElem.categoryName);
					dCat2.childNodes[1].childNodes[0].childNodes[0].setAttribute('alt',dateElem.categoryName);
					dCat2.childNodes[3].childNodes[0].setAttribute('href',"/category/"+dateElem.id);
					dCat2.childNodes[3].childNodes[0].innerHTML = dateElem.categoryName;
					boxCategory2.appendChild(dCat2);
				});
		    } 
		});

		$(document).on("click","#category",function(e){
			// Create content for product by category
			e.preventDefault();
			setHiddenfalse();
			delDomChild(document.getElementById("box-product2"));
			delDomChild(document.getElementById("product-list"));
			var category = '/product/by'+$(this).attr('href');	
			var categoryName = $(this).text();
			$.ajax({
				type: "GET",
				url: category,  
				data: {}, 
				dataType : "json",                    
				success: function (data, textStatus) {
					document.getElementById("product-box").removeAttribute("hidden");	
					document.getElementById('product-box').childNodes[1].innerHTML = categoryName;
					document.getElementById('product-box').setAttribute('style','margin-left:200px;');
					var productList = document.getElementById('product-list');
					data.forEach(function(dateElem) {
						var product = document.getElementById('mod-product-div').childNodes[1].cloneNode(true);
						product.childNodes[1].childNodes[1].childNodes[1].setAttribute("onclick","addToCart(this,"+dateElem.id+")");
						product.childNodes[3].childNodes[1].childNodes[0].setAttribute('href',dateElem.id);
						product.childNodes[3].childNodes[1].childNodes[0].childNodes[0].setAttribute('src',"/resources/images/data/"+dateElem.productImage);
						product.childNodes[3].childNodes[1].childNodes[0].childNodes[0].setAttribute('title',dateElem.productName);
						product.childNodes[3].childNodes[1].childNodes[0].childNodes[0].setAttribute('alt',dateElem.productName);
						product.childNodes[3].childNodes[3].innerHTML = dateElem.productPrice+" $.";
						product.childNodes[3].childNodes[5].childNodes[0].setAttribute('href',dateElem.id);
						product.childNodes[3].childNodes[5].childNodes[0].innerHTML = dateElem.productName;
						product.childNodes[3].childNodes[7].innerHTML = dateElem.productDescription;
						productList.appendChild(product);
						
					});
					
			    } 
			});
		});
		//Get all categories
		$(document).on("click","#categories",function(e){
			e.preventDefault();
			setHiddenfalse();
			delDomChild(document.getElementById("box-product2"));
			delDomChild(document.getElementById("product-list"));
			 $.ajax({
					type: "GET",
					url: '/category/',  
					data: {}, 
					dataType : "json",                    
					success: function (data, textStatus) { 
						document.getElementById("category-box").removeAttribute("hidden");
						document.getElementById("category-box").childNodes[1].innerHTML="Product catalog";
						var boxCategory2 = document.getElementById('box-product2');
						data.forEach(function(dateElem) {
							// Create content for categories with image
							var dCat2 = document.getElementById('mod-category-div').childNodes[1].cloneNode(true);
							dCat2.childNodes[1].childNodes[0].setAttribute('href',"/category/"+dateElem.id);
							dCat2.childNodes[1].childNodes[0].childNodes[0].setAttribute('src',"/resources/images/data/"+dateElem.categoryImagePath);
							dCat2.childNodes[1].childNodes[0].childNodes[0].setAttribute('title',dateElem.categoryName);
							dCat2.childNodes[1].childNodes[0].childNodes[0].setAttribute('alt',dateElem.categoryName);
							dCat2.childNodes[3].childNodes[0].setAttribute('href',dateElem.categoryImagePath);
							dCat2.childNodes[3].childNodes[0].innerHTML = dateElem.categoryName;
							boxCategory2.appendChild(dCat2);
						});
				    } 
				});
		});
		
//Get product info
		$(document).on("click","#product",function(e){
			e.preventDefault();
			setHiddenfalse();
			delDomChild(document.getElementById("product-info"));
			var product = '/product/'+$(this).attr('href');	
			  $.ajax({
					type: "GET",
					url: product,  
					data: {}, 
					dataType : "json",                    
					success: function (product, textStatus) { 
						document.getElementById("product-info").removeAttribute("hidden");
						var boxProductInfo = document.getElementById('product-info');
						var productInfo = document.getElementById('mod-product-info').childNodes[1].cloneNode(true);	
						productInfo.childNodes[1].innerHTML = product.productName;
						productInfo.childNodes[3].childNodes[1].childNodes[1].childNodes[0].setAttribute('href',"/resources/images/data/"+product.productImage);
						productInfo.childNodes[3].childNodes[1].childNodes[1].childNodes[0].setAttribute('title',product.productName);
						productInfo.childNodes[3].childNodes[1].childNodes[1].childNodes[0].childNodes[0].setAttribute('src',"/resources/images/data/"+product.productImage);
						productInfo.childNodes[3].childNodes[1].childNodes[1].childNodes[0].childNodes[0].setAttribute('title',product.productName);
						productInfo.childNodes[3].childNodes[1].childNodes[1].childNodes[0].childNodes[0].setAttribute('alt',product.productName);
						productInfo.childNodes[3].childNodes[3].childNodes[1].innerHTML = "<span>Model:</span> "+ product.id+"<br /><span>Availability:</span> In stock</div>"; 
						productInfo.childNodes[3].childNodes[3].childNodes[3].innerHTML ="Price "+product.productPrice+" $.";
						productInfo.childNodes[3].childNodes[3].childNodes[5].childNodes[1].childNodes[10].setAttribute("onclick","addToCart(this,"+product.id+")");
						productInfo.childNodes[7].childNodes[3].childNodes[0].childNodes[0].childNodes[0].innerHTML = product.productDescription;
						boxProductInfo.appendChild(productInfo);
				    } 
				});
		});

		$(document).on("click","#aboutCompany",function(e){
			e.preventDefault();
			setHiddenfalse();
			delDomChild(document.getElementById("page-info"));
			document.getElementById("page-info").removeAttribute("hidden");
			var boxProductInfo = document.getElementById('page-info');
			var productInfo = document.getElementById('mod-page-info-about').childNodes[1].cloneNode(true);
			boxProductInfo.appendChild(productInfo);
			
		});

		$(document).on("click","#button-cart",function(e){

			console.log(444);
			
		});
  });

/*
 * 
 * JS function for add products to cart
 * 
*/
function addToCart(e,element){
				var idProd = element;
				  var basePath = document.getElementsByTagName('base')[0].href;
				$.ajax({
						type: "POST",
						url: '/order/add',  
						data: {"id":idProd}, 
						dataType : "json",
						success: function (product, textStatus) { 
							console.log();
							$('#notification').html('<div class="success" style="display: none;">'+product[0]+'</div>');
							$(e).attr('value','In Cart!');
							e.removeAttribute("onclick");
							setTimeout(close, 3000);
							$('.success').fadeIn('slow');
						}
					});
				
}
var close = function() {
	delDomChild(document.getElementById("notification"));
}	
function delHtmlTags(x,startDel){
    for (i=startDel;i<x.length;)
            { 
                 if(x[i])
                {
                    x[i].parentNode.removeChild(x[i]);
                 }else
                 break;
            }
}
function delDomChild(element){
	while (element.firstChild) {
		  element.removeChild(element.firstChild);
		}
}
function setHiddenfalse(){
	document.getElementById("category-box").setAttribute('hidden',"false");
	document.getElementById("product-box").setAttribute('hidden',"false");
	document.getElementById("product-info").setAttribute('hidden',"false");
	document.getElementById("page-info").setAttribute('hidden',"false");
	
}
  