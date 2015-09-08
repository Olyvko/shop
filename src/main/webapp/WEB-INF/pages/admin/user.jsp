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
href="<c:url value="/resources/style/stylesheet/stylesheet_admin.css"/>"/></link>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery-1.7.1.min.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/ui/jquery-ui-1.8.16.custom.min.js"/>" /></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jscroller-0.4.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/running_line.js"/>" /></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/admuser.js"/>" /></script>
<c:set var="req" value="${pageContext.request}" />
<base href="${req.contextPath}" />

</head>	

<body>

<body>
<div id="container">
<div id="header">
<c:url value="/j_spring_security_logout" var="logoutUrl" />
 <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" />
</form>
  <div class="div1">
    <div class="div2"><img src="<c:url value="/resources/images/image/data/logo_admin.png"/>" title="Admin" /></div>
    <div class="div3"><img src="<c:url value="/resources/images/image/data/lock.png"/>" alt="" style="position: relative; top: 3px;" />&nbsp;Ви увійшли як <span>admin</span></div>
  </div>
  <div id="menu">
    <ul class="left" >
       <li id="dashboard"><a href="<c:url value="/admin"/>" class="top">Control Panel</a></li>
      <li id="catalog" class="selected"><a href="<c:url value="/admin/category"/>" class="top">Category</a></li> 
      <li id="system"><a href="<c:url value="/admin/user"/>" class="top">Users</a></li> 
    </ul> 
    <ul class="right" >
      <li id="store"><a class="top" href="javascript:formSubmit()">Sign out</a></li>
    </ul> 
  </div>
</div>
<div id="content"> 
</div>

<div id="modules" hidden="false">
	<div  id="mod-user-list">
	  <div class="box" style="margin-top: 20px">
	    <div class="heading">
	      <h1>USERS</h1>
	    </div>
	    <div class="content" style="padding-left: 5%;padding-right: 5%">
		  <table class="list">
	          <thead>
	            <tr>
	              <td class="left"><a>Id</a>
	                </td>
	              <td class="left"><a>Login</a>
	                </td>
	              <td class="left"><a>Name and Surname</a>
	                </td>
	              <td class="left"><a>Address</a>
	                </td>
	              <td class="right">Active</td>
	            </tr>
	          </thead>
	          <tbody>
	          </tbody>
	        </table>
		</div>
	  </div>
	</div>
	
	
	<div  id="mod-user-info">
	      <table>
	        <tbody>
	            <tr>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="right"><a id="status_change" title="Change status"><span></span></a></td>
	            </tr>
	        </tbody>
	      </table>
	</div>
	
</div>

</div>   

</body>
</html>

