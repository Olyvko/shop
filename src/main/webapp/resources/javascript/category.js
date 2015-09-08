 $( document ).ready(function() {
	 var basePath = document.getElementsByTagName('base')[0].href;
	  $.ajax({
			type: "GET",
			url: '/admin/category/',  
			data: {}, 
			dataType : "json",                    
			success: function (data, textStatus) { 
				var orderNode = document.getElementById('mod-category-list').childNodes[1].cloneNode(true);
				orderNode.childNodes[1].childNodes[1].innerHTML = "CATEGORY";
				var tbodyNode = orderNode.childNodes[3].childNodes[1].childNodes[3];
				var boxContent = document.getElementById('content');
				
				data.forEach(function(dateElem) {
					var userNode = document.getElementById('mod-category-info').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
					userNode.childNodes[1].innerHTML = dateElem.id;
					userNode.childNodes[3].innerHTML = dateElem.categoryName;
					userNode.childNodes[3].setAttribute("title",dateElem.categoryName);
					userNode.childNodes[5].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/delete.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
					userNode.childNodes[7].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/arrow_open.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
					userNode.childNodes[9].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/edit.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
					tbodyNode.appendChild(userNode);
				});
				boxContent.appendChild(orderNode);	
				
		    } 
		});
	  
	  //GET CATEGORY LIST
	  $(document).on("click","#category_list",function(e){
			e.preventDefault();
			delDomChild(document.getElementById('content'));
			 $.ajax({
					type: "GET",
					url: '/admin/category/',  
					data: {}, 
					dataType : "json",                    
					success: function (data, textStatus) { 
						var orderNode = document.getElementById('mod-category-list').childNodes[1].cloneNode(true);
						orderNode.childNodes[1].childNodes[1].innerHTML = "CATEGORY";
						var tbodyNode = orderNode.childNodes[3].childNodes[1].childNodes[3];
						var boxContent = document.getElementById('content');
						
						data.forEach(function(dateElem) {
							var userNode = document.getElementById('mod-category-info').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
							userNode.childNodes[1].innerHTML = dateElem.id;
							userNode.childNodes[3].innerHTML = dateElem.categoryName;
							userNode.childNodes[3].setAttribute("title",dateElem.categoryName);
							userNode.childNodes[5].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/delete.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
							userNode.childNodes[7].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/arrow_open.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
							userNode.childNodes[9].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/edit.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
							tbodyNode.appendChild(userNode);
						});
						boxContent.appendChild(orderNode);	
						
				    } 
				});		
				
		});
	  //ADD NEW CTEGORY
	  $(document).on("click","#add_category",function(e){
			e.preventDefault();
			var valArr = e.target.parentNode.parentNode.childNodes[1].childNodes[3].childNodes[1];
			// Create new category
			$.ajax({
				type: "POST",
				url: '/admin/category/create',  
				data: {"id":'',
					   "categoryName":valArr.childNodes[1].childNodes[0].value,
					   "categoryImagePath":valArr.childNodes[3].childNodes[1].childNodes[3].value}, 
				dataType : "json",                    
				success: function (data, textStatus) {
					document.getElementById('category_list').click();
			    } 
			});		
				
		});
	  //ADD NEW CTEGORY FORM
	  $(document).on("click","#add_category_form",function(e){
			e.preventDefault();
			delDomChild(document.getElementById('content'));
			var orderNode = document.getElementById('mod-category-add').childNodes[1].cloneNode(true);
			orderNode.childNodes[1].childNodes[1].innerHTML = "ADD NEW CATEGORY";
			var boxContent = document.getElementById('content');
			boxContent.appendChild(orderNode);	
					
				
		});
	  //EDIT CATEGORY
	  $(document).on("click","#edit_category",function(e){
			e.preventDefault();
			var valArr = e.target.parentNode.parentNode.childNodes[1].childNodes[3].childNodes[1];
			var idCategory = e.target.parentNode.parentNode.parentNode.childNodes[1].childNodes[1].getAttribute("title");
			// Edit new category
			
			$.ajax({
				type: "POST",
				url: '/admin/category/update',  
				data: {"id":idCategory,
					   "categoryName":valArr.childNodes[1].childNodes[0].value,
					   "categoryImagePath":valArr.childNodes[3].childNodes[1].childNodes[3].value}, 
				dataType : "json",                    
				success: function (data, textStatus) {
					console.log(data);
					document.getElementById('category_list').click();
			    } 
			});	
			
				
		});
	  //EDIT CATEGORY FORM
	  $(document).on("click","#edit_category_form",function(e){
			e.preventDefault();
			delDomChild(document.getElementById('content'));
			var orderNode = document.getElementById('mod-category-add').childNodes[1].cloneNode(true);
			var idCategory = e.target.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			orderNode.childNodes[1].childNodes[1].setAttribute("title",idCategory);
			orderNode.childNodes[1].childNodes[1].innerHTML = "EDIT CATEGORY #"+idCategory;
			orderNode.childNodes[3].childNodes[3].childNodes[1].setAttribute("id","edit_category");
			orderNode.childNodes[3].childNodes[3].childNodes[1].innerHTML = "Edit category";
			var boxContent = document.getElementById('content');
			$.ajax({
				type: "GET",
				url: '/admin/category/'+idCategory,  
				data: {}, 
				dataType : "json",                    
				success: function (data, textStatus) { 
					orderNode.childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[1].childNodes[0].value = 	data.categoryName;
					orderNode.childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[3].value = 	data.categoryImagePath;	
					boxContent.appendChild(orderNode);	
				} 
			});	
					
				
		});
	  //SHOW PRODUCT BY CATEGORY
	  $(document).on("click","#products",function(e){
			e.preventDefault();
			var goNext = e.target.parentNode.getAttribute("title");
			productNodeName = e.target.parentNode.parentNode.parentNode.childNodes[3];
			var categoryName = productNodeName.getAttribute("title");
			var categoryId = e.target.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			delDomChild(productNodeName);
			if(goNext=="Show"){
				defaultCatName();
				var productNode = document.getElementById('mod-product-list').childNodes[1].cloneNode(true);
				productNode.childNodes[1].childNodes[1].innerHTML = "Products - "+categoryName;
				productNodeName.appendChild(productNode);
				e.target.setAttribute('style',"background:  url('"+"/resources/images/image/arrow_close.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
				e.target.parentNode.setAttribute("title","Close");
				$.ajax({
						type: "GET",
						url: '/admin/product/by/category/'+categoryId,  
						data: {}, 
						dataType : "json",                    
						success: function (data, textStatus) { 
							data.forEach(function(dateElem) {
								var modProductNode = document.getElementById('mod-product-info').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
								modProductNode.childNodes[1].innerHTML = dateElem.id;
								modProductNode.childNodes[3].innerHTML = dateElem.productName;
								modProductNode.childNodes[5].innerHTML = dateElem.productPrice;
								modProductNode.childNodes[7].innerHTML = dateElem.productDescription;
								modProductNode.childNodes[9].innerHTML = dateElem.productImage;
								modProductNode.childNodes[11].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/delete.png') center center no-repeat; display: inline-block; width: 20px;height: 20px;");
								modProductNode.childNodes[13].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/edit.png') center center no-repeat; display: inline-block; width: 20px;height: 20px;");
								productNode.childNodes[3].childNodes[1].childNodes[3].appendChild(modProductNode);
							});
					    } 
					});
			}else{
				productNodeName.innerHTML = categoryName;
				e.target.setAttribute('style',"background:  url('"+"/resources/images/image/arrow_open.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
				e.target.parentNode.setAttribute("title","Show");
			}
		});

	  //ADD NEW CTEGORY FORM
	  $(document).on("click","#add_product_form",function(e){
			e.preventDefault();
			var categoryNameNode = e.target.parentNode.parentNode.parentNode.parentNode;
			var categoryName = categoryNameNode.getAttribute("title");
			delDomChild(categoryNameNode);
			
			var modProductNode = document.getElementById('mod-product-add').childNodes[1].cloneNode(true);
			modProductNode.childNodes[1].childNodes[1].innerHTML = "Category - "+categoryName+", add new Product:";
			categoryNameNode.appendChild(modProductNode);	
					
				
		});

	  //SHOW PRODUCT BY CATEGORY
	  $(document).on("click","#product_list",function(e){
			e.preventDefault();
			
			productNodeName = e.target.parentNode.parentNode.parentNode.parentNode;
			var categoryName = productNodeName.getAttribute("title");
			var categoryId = e.target.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			delDomChild(productNodeName);
				var productNode = document.getElementById('mod-product-list').childNodes[1].cloneNode(true);
				productNode.childNodes[1].childNodes[1].innerHTML = "Products - "+categoryName;
				productNodeName.appendChild(productNode);
				$.ajax({
						type: "GET",
						url: '/admin/product/by/category/'+categoryId,  
						data: {}, 
						dataType : "json",                    
						success: function (data, textStatus) { 
							data.forEach(function(dateElem) {
								var modProductNode = document.getElementById('mod-product-info').childNodes[1].childNodes[1].childNodes[1].cloneNode(true);
								modProductNode.childNodes[1].innerHTML = dateElem.id;
								modProductNode.childNodes[3].innerHTML = dateElem.productName;
								modProductNode.childNodes[5].innerHTML = dateElem.productPrice;
								modProductNode.childNodes[7].innerHTML = dateElem.productDescription;
								modProductNode.childNodes[9].innerHTML = dateElem.productImage;
								modProductNode.childNodes[11].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/delete.png') center center no-repeat; display: inline-block; width: 20px;height: 20px;");
								modProductNode.childNodes[13].childNodes[0].childNodes[0].setAttribute('style',"background:  url('"+"/resources/images/image/edit.png') center center no-repeat; display: inline-block; width: 20px;height: 20px;");
								productNode.childNodes[3].childNodes[1].childNodes[3].appendChild(modProductNode);
							});
					    } 
					});
				
		});
	  // Load image on server and get name
	  $(document).on("click","#imageLoad",function(e){
		  e.preventDefault();
		  var oMyForm = new FormData();
		  oMyForm.append("file", document.getElementById("uploadfile").files[0]);
			$.ajax({
				type: "POST",
				url: '/admin/product/image/create',  
				data: oMyForm,
				dataType: 'json',
			    processData: false,
			    contentType: false,                    
				success: function (data, textStatus) {
					console.log(data);
					e.target.parentNode.childNodes[3].value = data[0];
			    } 
			});	
		});
	  //ADD NEW PRODUCT
	  $(document).on("click","#add_product",function(e){
			e.preventDefault();
			var valArr = e.target.parentNode.parentNode.childNodes[1].childNodes[3].childNodes[1];
			var idProduct = e.target.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			console.log(!isNaN(valArr.childNodes[3].childNodes[0].value));
			// validation
					if (valArr.childNodes[1].childNodes[0].value == ''
						||valArr.childNodes[3].childNodes[0].value == ''
							||valArr.childNodes[5].childNodes[0].value == ''
								||valArr.childNodes[7].childNodes[1].childNodes[3].value == ''
									||isNaN(valArr.childNodes[3].childNodes[0].value)) {
						$('#notification').html('<div class="success" style="display: none;">Enter correct all fields!!!</div>');
						$('.success').fadeIn('slow');
						setTimeout(close, 3000);
						return;
					} 
			$.ajax({
				type: "POST",
				url: '/admin/product/create',  
				data: {"id":'',
					   "productName":valArr.childNodes[1].childNodes[0].value,
					   "productPrice":valArr.childNodes[3].childNodes[0].value,
					   "productDescription":valArr.childNodes[5].childNodes[0].value,
					   "productImage":valArr.childNodes[7].childNodes[1].childNodes[3].value,
					   "productCategory":idProduct
					   }, 
				dataType : "json",                    
				success: function (data, textStatus) {
					document.getElementById('product_list').click();
			    } 
			});	

		});

	  //DELETE PRODUCT
	  $(document).on("click","#delete_product",function(e){
			e.preventDefault();
			var id = e.target.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			console.log(id);
			$.ajax({
					type: "GET",
					url: '/admin/product/delete/'+id,  
					data: {}, 
					dataType : "json",                    
					success: function (data, textStatus) { 
						document.getElementById('product_list').click();
				    } 
				});
		});
	  //EDIT PRODUCT FORM
	  $(document).on("click","#edit_product_form",function(e){
			e.preventDefault();
			var productNode = document.getElementById('mod-product-add').childNodes[1].cloneNode(true);
			var idProduct = e.target.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			productNode.childNodes[1].childNodes[1].setAttribute("title",idProduct);
			productNode.childNodes[1].childNodes[1].innerHTML = "EDIT PRODUCT #"+idProduct;
			productNode.childNodes[3].childNodes[3].childNodes[1].setAttribute("id","edit_product");
			productNode.childNodes[3].childNodes[3].childNodes[1].innerHTML = "Edit product";
			var boxContent = e.target.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
			delDomChild(boxContent);
			$.ajax({
				type: "GET",
				url: '/admin/product/'+idProduct,  
				data: {}, 
				dataType : "json",                    
				success: function (data, textStatus) { 
					productNode.childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[1].childNodes[0].value = 	data.productName;
					productNode.childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[3].childNodes[0].value = 	data.productPrice;	
					productNode.childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[5].childNodes[0].value = 	data.productDescription;
					productNode.childNodes[3].childNodes[1].childNodes[3].childNodes[1].childNodes[7].childNodes[1].childNodes[3].value = 	data.productImage;	
					boxContent.appendChild(productNode);	
				} 
			});	
					
				
		});
	  //EDIT PRODUCT
	  $(document).on("click","#edit_product",function(e){
			e.preventDefault();
			var valArr = e.target.parentNode.parentNode.childNodes[1].childNodes[3].childNodes[1];
			var idCategory = e.target.parentNode.parentNode.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			var idProduct = e.target.parentNode.parentNode.parentNode.childNodes[1].childNodes[1].getAttribute("title");
			console.log(valArr.childNodes[1].childNodes[0].value);
			console.log(valArr.childNodes[3].childNodes[0].value);
			console.log(valArr.childNodes[5].childNodes[0].value);
			console.log(idCategory);
			console.log(idProduct);
			console.log(valArr.childNodes[7].childNodes[1].childNodes[3].value);
			$.ajax({
				type: "POST",
				url: '/admin/product/update',  
				data: {"id":idProduct,
					   "productName":valArr.childNodes[1].childNodes[0].value,
					   "productPrice":valArr.childNodes[3].childNodes[0].value,
					   "productDescription":valArr.childNodes[5].childNodes[0].value,
					   "productImage":valArr.childNodes[7].childNodes[1].childNodes[3].value,
					   "productCategory":idCategory}, 
				dataType : "json",                    
				success: function (data, textStatus) {
					document.getElementById('product_list').click();
			    } 
			});	
				
		});
	  $(document).on("click","#delete_category",function(e){
			e.preventDefault();
			var id = e.target.parentNode.parentNode.parentNode.childNodes[1].innerHTML;
			$.ajax({
					type: "GET",
					url: '/admin/category/delete/'+id,  
					data: {}, 
					dataType : "json",                    
					success: function (data, textStatus) { 
						document.getElementById('category_list').click();
				    } 
				});
			
				
		});
 });

 function defaultCatName() {
	 var baseP = document.getElementsByTagName('base')[0].href;
	 var bodyCategories = document.getElementById('bodyCategories').childNodes;
		for (i=1;i<bodyCategories.length;i++)
     { 
          if(bodyCategories[i])
         {
         	var categoryName = bodyCategories[i].childNodes[3].getAttribute("title");
				bodyCategories[i].childNodes[3].innerHTML = categoryName;
				bodyCategories[i].childNodes[7].childNodes[0].setAttribute("title","Show");
				bodyCategories[i].childNodes[7].childNodes[0].childNodes[0].setAttribute('style',"background:  url('/resources/images/image/arrow_open.png') center center no-repeat; display: inline-block; width: 24px;height: 24px;");
			 }else
          break;
     } 
 } 
 function formSubmit() {
 	document.getElementById("logoutForm").submit();
 }  

 var close = function() {
 	delDomChild(document.getElementById("notification"));
 }
 function delDomChild(element){
	  	while (element.firstChild) {
	  		  element.removeChild(element.firstChild);
	  		}
	  }
 
 function IsNumeric(num) {
     return (num >=0 || num < 0);
}