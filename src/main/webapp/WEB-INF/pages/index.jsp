<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Olyvko Shop</title>
<meta name="description" content="Olyvko Shop." />
 
<link rel="stylesheet" type="text/css" 
href="<c:url value="/resources/style/stylesheet/stylesheet.css"/>"/></link>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery-1.7.1.min.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/ui/jquery-ui-1.8.16.custom.min.js"/>" /></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jscroller-0.4.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/running_line.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/javascr.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/main.js"/>" /></script>
<c:set var="req" value="${pageContext.request}" />
<base href="${req.contextPath}" />

</head>	

<body>
<div id="top_panel">
<div id="panel">
<c:url value="/j_spring_security_logout" var="logoutUrl" />
 <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" />
</form>
<div id="welcome">
</div>
</div>
</div>	

<div id="container">
<div id="header">
 <div id="logo"><a href="/admin"><img src="<c:url value="/resources/images/image/data/logo.png"/>"   title="Olyvko Shop" alt="Olyvko Shop" /></a></div>
<div id="top_contact">
 <div id="quest"><span id="have">Question?</span><span id="call">Call!</span></div>
 <div id="phone">
  <span id="code">(063)</span><span id="body">814-5-738</span>
 </div>
</div>


  <div id="cart">
  <div class="heading">

	<style type="text/css">
	 #header #cart .heading h4 {margin:-10px 0px 3px 0 !important;}
	 #header #cart .heading {margin:10px 0px 0 0 !important}
	 #header #cart.active .heading {padding-top:0 !important}
	 </style>
	  <img style="margin:0 -73px -30px" src="<c:url value="/resources/images/image/data/cart_full.png"/>">
	 
	    <h4>Cart</h4>
	    <div class="checkout"><a href="<c:url value="/order/"/>">View Cart</a></div>
   
</div>
</div>


<div id="search">
	<div class="button-search"></div>
	<input type="text" name="search" placeholder="Search"  />
</div>

</div>

<div id="menu">
	<ul>
		<li><a id="categories" href="/category/">Home</a></li> | <li><a id="aboutCompany">About company</a></li> | <li><a id="aboutCompany">Certifications</a></li> | <li><a id="aboutCompany">Payment and delivery</a></li> | <li><a id="aboutCompany">Actions</a></li> | <li><a id="aboutCompany">Adviser</a></li> | <li><a id="aboutCompany">Contact</a></li> 
	</ul>
</div>

<div id="notification"></div>

<div id="scroller_container">
	<div id="scroller"> 
	Shop is under construction! Thank you for understanding !!! Sincerely, Roman!
	</div>
</div>


<div id="content">
	<div id="column-left">
		<div class="box" >
		  <div class="box-heading">Category</div>
		  <div class="box-content">
			  <div class="box-category" id="box-category">
				 <ul>
				</ul>
			  </div>
		  </div>
		</div>
	</div>
	<div class="box" id="category-box" >
		<div class="box-heading2"></div>
		<div class="box-category2">
			<div class="box-product2" id="box-product2">
			</div>
		</div>
	</div>
	<div id="product-box">
		<h1></h1>
		<div class="product-list" id="product-list">
		</div>
	</div>
	
	<div id="product-info" style="margin-left: 200px"> 
	</div>
	
	<div id="page-info" style="margin-left: 200px"> 
	</div>
	
</div>
</div>

<div id="footer_box">
<div id="footer">
  <div class="column">
    <h3>INFORMATION</h3>
    <ul>
      <li><a href="/">About company</a></li>
      <li><a href="/">Actions</a></li>
    </ul>
  </div>
  <div class="column">
    <h3>Customer Service</h3>
    <ul>
      <li><a href="/">Contacts</a></li>
    </ul>
  </div>
  <div class="column">
    <h3>Additionally</h3>
    <ul>
      <li><a href="/">Companies</a></li>
    </ul>
  </div>
  <div class="column">
    <h3>Account</h3>
    <ul>
      <li><a href="/">Account</a></li>
    </ul>
  </div>
</div>

<div id="modules" hidden="false">
	//Module for category left list
	<div  id="mod-category-li">
		 <li id="li-box-category">
			<a id="category" ></a>
		 </li>
	</div>
	//Module for category content list
	<div  id="mod-category-div">
		<div>
			<div class="image"><a id="category" href=""><img style="width:100px;" src="" title="" alt="" /></a></div>
			<div class="name"><a id="category" href=""></a></div>
		</div>
	</div>
	//Module for product content
	<div  id="mod-product-div">
			<div>
				<div class="right">
					<div class="cart">
						<input type="button" value="Add to cart" class="button" />
					</div>
				</div>
				<div class="left">
					<div class="image"><a id="product"><img style="width: 80px"/></a></div>
					<div class="price"></div>
					<div class="name"><a id="product"></a><br style="color:#e3e3e3;"></div>
					<div class="description"></div>
				</div>
			</div>
	</div>
	//Module for product content
	<div  id="mod-product-info">
	  <div>
		<h1></h1>
	    <div class="product-info">
	        <div class="left">
	            <div class="image"><a href="" title="" class="colorbox" rel="colorbox"><img src="" title="" alt="" id="image" /></a></div>
	        </div>
	        <div class="right">
		      <div class="description">
		      </div>
		      <div class="price"><br/>
		      </div>
		      <div class="cart">
			      <div>Quantity:          
					<script> $(document).ready( function() { var elm = $('#htop'); function spin( vl ) { elm.val( parseInt( elm.val(), 10 ) + vl ); } $('#increase').click( function() { spin( 1 ); } ); $('#decrease').click( function() { spin( -1 ); } ); }); </script> <input type="button" id="decrease" value="-" /><input type="text" name="quantity" id="htop" size="2" value="1" /> <input type="button" id="increase" value="+" />
				  	<input type="hidden" name="product_id" size="2" value="143" />
			          &nbsp;
			         <input type="button" value="Add to cart" id="button-cart" class="button" />
			       </div>
		        </div>
		        <div class="review">
			        <div><a>0 reviews</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a>Write a Review</a></div>
			        <div class="share"><!-- AddThis Button BEGIN -->
			          <div class="addthis_default_style"><a class="addthis_button_compact">Share</a> <a class="addthis_button_email"></a><a class="addthis_button_print"></a> <a class="addthis_button_facebook"></a> <a class="addthis_button_twitter"></a></div>
			          <script type="text/javascript" src="//s7.addthis.com/js/250/addthis_widget.js"></script> 
			          <!-- AddThis Button END --> 
			        </div>
			     </div>
	          </div>
	     </div>
	     <div id="tabs" class="htabs"><a href="#tab-description" class="selected" style="display: inline;">Description</a>
		 	<a href="#tab-review" style="display: inline;">Response (0)</a>
		  </div>
		  <div id="tab-description" class="tab-content">
			  <h2></h2>
			  <p><span style="font-size:12px;"><span style="font-family:arial,helvetica,sans-serif;"><span style="color: rgb(68, 68, 68); line-height: 18px; text-indent: 18px;"></span></span></span></p>
		  </div>
	  </div>
	</div>
	//Module for page aboutCompany
	<div  id="mod-page-info-about">
	  <div>
	  <h1>About Company</h1>
		  <p>
			Our company .... Tralya lya =)</p>
		  <p>
			Our company .... Tralya lya =)</p>
		  <p>
			Our company .... Tralya lya =)</p>
		<div class="buttons">
		    <div class="right"><a id="categories" href="/shop/category/" class="button">Continue</a></div>
		  </div>
	  </div>
	</div>
</div>

</div>
</body>
</html>

