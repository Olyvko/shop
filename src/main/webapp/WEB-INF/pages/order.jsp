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
	src="<c:url value="/resources/javascript/order.js"/>" /></script>
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
	    <div class="checkout"><a href="/shop/order/">View Cart</a></div>
   
</div>
</div>


<div id="search">
	<div class="button-search"></div>
	<input type="text" name="search" placeholder="Search"  />
</div>

</div>

<div id="menu">
	<ul>
		<li><a id="categories" href="<c:url value="/"/>">Home</a></li> | <li><a id="aboutCompany">About company</a></li> | <li><a id="aboutCompany">Certifications</a></li> | <li><a id="aboutCompany">Payment and delivery</a></li> | <li><a id="aboutCompany">Actions</a></li> | <li><a id="aboutCompany">Adviser</a></li> | <li><a id="aboutCompany">Contact</a></li> 
	</ul>
</div>

<div id="notification"></div>

<div id="scroller_container">
	<div id="scroller"> 
	Shop is under construction! Thank you for understanding !!! Sincerely, Roman!
	</div>
</div>

<div id="content">
		
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
	<div  id="mod-order-cart">
	 <div>
	  <h1>Cart  </h1>
	   <div class="cart-info">
	      <table>
	        <thead>
	          <tr>
	            <td class="image">Image</td>
	            <td class="name">Name</td>
	            <td class="model">Model</td>
	            <td class="price">Price</td>
	          </tr>
	        </thead>
	        <tbody id="tbodyCart">
	        </tbody>
	      </table>
	    </div>
	  <div class="buttons">
	    <div class="right"><a id="addOrder" class="button">Check out</a></div>
	    <div class="left"><a id="historyOrder" class="button">Orders history</a></div>
	    <div class="center"><a href="<c:url value="/"/>" class="button">Continue Shopping</a></div>
	  </div>
	
	 </div>
	</div>
	
	<div  id="mod-order-table">
	 <div>
	  <h1>Orders history  </h1>
	   <div class="cart-info">
	      <table>
	        <thead>
	          <tr>
	            <td class="name">Name</td>
	            <td class="model">Date</td>
	          </tr>
	        </thead>
	        <tbody id="tbodyOrder">
	        </tbody>
	      </table>
	    </div>
	  <div class="buttons">
	    <div class="left"><a id="cartOrder" class="button">Review Cart</a></div>
	    <div class="center"><a href="<c:url value="/"/>" class="button">Continue Shopping</a></div>
	  </div>
	
	 </div>
	</div>
	
	
	  <div id="mod-order-cart-product">
	      <table>
	        <tbody>
	           <tr>
	            <td class="image">              
	            	<a><img style="width:80px"/></a>
	            </td>
	            <td class="name">
	            	<a></a>
	            </td>
	            <td class="model"></td>
			    <td class="price"></td>
	          </tr>
	        </tbody>
	      </table>
	  </div>
	
	  <div id="mod-order">
	      <table>
	        <tbody>
	           <tr>
	            <td class="name">
	            	<a></a>
	            </td>
			    <td class="model"></td>
	          </tr>
	        </tbody>
	      </table>
	  </div>	
</div>

</div>
</body>
</html>

