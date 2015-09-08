<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	src="<c:url value="/resources/javascript/category.js"/>" /></script>
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
<div> 
	<div id="notification"></div>
</div>
<div id="content"> 
</div>

<div id="modules" hidden="false">
	<div  id="mod-category-list">
	  <div class="box" style="margin-top: 20px">
	    <div class="heading">
	      <h1></h1>
	       <div class="buttons">
	       		<a class="button" id="add_category_form" >New Category</a>
	       </div>
	    </div>
	    <div class="content">
		  <table class="list">
	          <thead>
	            <tr>
	              <td class="left"><a>Id</a>
	                </td>
	              <td class="left"><a>Name</a>
	                </td>
	              <td class="right" style="width: 30px">Delete</td>
	              <td class="left" style="width: 30px"><a>Products</a>
	              <td class="left" style="width: 30px"><a>Edit</a>
	                </td>
	            </tr>
	          </thead>
	          <tbody id="bodyCategories">
	          </tbody>
	        </table>
		</div>
	  </div>
	</div>
	
	
	<div  id="mod-category-info">
	      <table>
	        <tbody>
	            <tr>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="right"><a id="delete_category" title="Delete" ><span></span></a></td>
	              <td class="right"><a id="products" title="Show" ><span></span></a></td>
	              <td class="right"><a id="edit_category_form" title="Edit" ><span></span></a></td>
	            </tr>
	        </tbody>
	      </table>
	</div>
	
	<div  id="mod-product-list">
	  <div class="box">
	    <div class="heading">
	      <h1>Products</h1>
	       <div class="buttons">
	       		<a class="button" id="add_product_form" >New Product</a>
	       </div>
	       <div class="buttons" hidden="false">
	       		<a class="button" id="product_list" >Product List</a>
	       </div>
	    </div>
	    <div class="content">
		  <table class="list">
	          <thead>
	            <tr>
	              <td class="left"><a>Id</a></td>
	              <td class="left"><a>Name</a></td>
	              <td class="left"><a>Price</a></td>
	              <td class="left"><a>Description</a></td>
	              <td class="left"><a>Image</a></td>
	              <td class="right" style="width: 20px">Delete</td></td>
	              <td class="right" style="width: 20px"><a>Edit</a>
	            </tr>
	          </thead>
	          <tbody>
	          </tbody>
	        </table>
		</div>
	  </div>
	</div>
	
	
	<div  id="mod-product-info">
	      <table>
	        <tbody>
	            <tr>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="left"></td>
	              <td class="right"><a id="delete_product" title="Delete" ><span></span></a></td>
	              <td class="right"><a id="edit_product_form" title="Delete" ><span></span></a></td>
	            </tr>
	        </tbody>
	      </table>
	</div>
	
	<div  id="mod-category-add">
	  <div class="box" style="margin-top: 20px">
	    <div class="heading">
	      <h1></h1>
	       <div class="buttons">
	       		<a class="button" id="category_list" >Category List</a>
	       </div>
	    </div>
	    <div class="content">
		  <table class="list">
	          <thead>
	            <tr>
	              <td class="left"><a>Name</a></td>
	              <td class="left"><a>Image</a></td>
	            </tr>
	          </thead>
	          <tbody>
	            <tr>
	              <td class="left"><input type="text" size="100" ></td>
	              <td class="left">
	              <form:form method="POST" commandName="file"  enctype="multipart/form-data">
			        Upload image please:
			        <input type="file" id="uploadfile" style="opacity:0;width:0px" />
					<input type="hidden" name="imagename"/>
			        <input type="submit" value="Select Image" id="imageLoad" />
    				<span style="margin-left: 5px;margin-left: 20px">Image not selected</span>
    				<img style="width:30px;" src="" />
			    </form:form></td>
	            </tr>
	          </tbody>
	        </table>
	       <div class="buttons" style="float: right">
	       		<a class="button" id="add_category" >Add new category</a>
	       </div>
		</div>
	  </div>
	</div>
	<div  id="mod-product-add">
	  <div class="box" style="margin-top: 20px">
	    <div class="heading">
	      <h1></h1>
	       <div class="buttons">
	       		<a class="button" id="product_list" >Product List</a>
	       </div>
	    </div>
	    <div class="content">
		  <table class="list">
	          <thead>
	            <tr>
	              <td class="left"><a>Name</a></td>
	              <td class="left"><a>Price</a></td>
	              <td class="left"><a>Description</a></td>
	              <td class="left"><a>Image</a></td>
	            </tr>
	          </thead>
	          <tbody>
	            <tr>
	              <td class="left"><input type="text" ></td>
	              <td class="left"><input type="text" ></td>
	              <td class="left"><input type="text" ></td>
	              <td class="left">
	              <form:form method="POST" commandName="file"  enctype="multipart/form-data">
			        Upload image please:
			        <input type="file" id="uploadfile" style="opacity:0;width:0px" />
					<input type="hidden" name="imagename"/>
			        <input type="submit" value="Select Image" id="imageLoad" />
    				<span style="margin-left: 5px;margin-left: 20px">Image not selected</span>
    				<img style="width:30px;" src="  " />
			    </form:form>
			    </td>
	            </tr>
	          </tbody>
	        </table>
	       <div class="buttons" style="float: right">
	       		<a class="button" id="add_product" >Add new product</a>
	       </div>
		</div>
	  </div>
	</div>
</div>

</div>   

</body>
</html>

