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
	src="<c:url value="/resources/javascript/login.js"/>" /></script>

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
		<li><a id="categories" href="<c:url value="/"/>">Home</a></li> | <li><a id="aboutCompany">About company</a></li> | <li><a id="aboutCompany">Certifications</a></li> | <li><a id="aboutCompany">Payment and delivery</a></li> | <li><a id="aboutCompany">Actions</a></li> | <li><a id="aboutCompany">Adviser</a></li> | <li><a id="aboutCompany">Contact</a></li> 
	</ul>
</div>
	<c:if test="${not empty error}">
			<div id="notification"><div class="warning">${error}</div></div>
			<div class="error">${error}</div>
		</c:if>
<div id="notification"></div>

<div id="scroller_container">
	<div id="scroller"> 
	Shop is under construction! Thank you for understanding !!! Sincerely, Roman!
	</div>
</div>


<div id="content">
	<div id="goLoginExist">
	  <h1>Authentication</h1>
	  <div class="login-content">
	    <div class="left">
	      <h2>New user</h2>
	      <div class="content">
	        <p><b>Create an account</b></p>
	        <p>By registering, you can make purchases faster, be always aware of the status of active orders and track order you made earlier.</p>
	        <a id="formUserAdd"   class="button">Continue</a></div>
	    </div>
		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
	    <div class="right">
	      <h2>Existing user</h2>
	        <div class="content">
	          <p>Entry for existing user</p>
	          <b>e-mail:</b><br />
	          <input type="text" name="username" value="" />
	          <br />
	          <br />
	          <b>Password:</b><br />
	          <input type="password" name="password" value="" />
	          <br />
	          <br />
	          <input type="submit" id="createUserExist"  value="Enter" class="button" />
	        </div>
	    </div>
		</form>
	  </div>
	</div>
	<div id="goLoginNew" hidden="false">
	  <h1>Create an account</h1>
	  <p>If you already have an account, please, <a id="formUserExist">login</a></p>
	    <h2>Personal data</h2>
	    <div class="content">
	      <table class="form">
	        <tr>
	          <td><span class="required">*</span> Name:</td>
	          <td><input type="text" id="firstname" name="firstname" value="" />
	            </td>
	        </tr>
	        <tr>
	          <td><span class="required">*</span> Surname:</td>
	          <td><input type="text" id="username"  name="username" value="" />
	            </td>
	        </tr>
	        <tr>
	          <td><span class="required">*</span> E-mail:</td>
	          <td><input type="text" id="email"  name="email" value="" />
	            </td>
	        </tr>
	      </table>
	    </div>
	    <h2>Address</h2>
	    <div class="content">
	      <table class="form">
	        <tr>
	          <td><span class="required">*</span> Address:</td>
	          <td><input type="text" id="address"  name="address" value="" />
	            </td>
	        </tr>
	      </table>
	    </div>
	    <h2>Password</h2>
	    <div class="content">
	      <table class="form">
	        <tr>
	          <td><span class="required">*</span> Password:</td>
	          <td><input type="password" id="password"  name="password" value="" />
	            </td>
	        </tr>
	        <tr>
	          <td><span class="required">*</span> Confirm password:</td>
	          <td><input type="password" id="confirm" name="confirm" value="" />
	            </td>
	        </tr>
	      </table>
	    </div>
	    <div class="buttons">
	      <div class="right" >
	            <input type="submit" id="createUser" value="Continue" class="button" />
	      </div>
	    </div>
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



</div>
</body>
</html>

