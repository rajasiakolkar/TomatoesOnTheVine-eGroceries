<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
	
	<h1>Your Inventory</h1>

</div>

<table class="table table-striped table-hover">
	<thead>
		<tr class="bg-success">
		 	<th>Photo</th>
		 	<th>Name</th>
		 	<th>Category</th>
		 	<th>Description</th>
		 	<th>Price</th>
		 	<th></th>
		</tr>
	</thead>
	<c:forEach items="${products}" var="product">
	<tr>
		<td><img src="#" alt="image"></td>
		<td>${product.productName}</td>	
		<td>${product.productCategory}</td>
		<td>${product.productDescription}</td>
		<td>${product.productPrice} USD</td>
		<td>
		<a href="<spring:url value="/productList/productDetails/${product.productId}" />">
		<span class="glyphicon glyphicon-info-sign"></span></a>
		<a href="<c:url value="/admin/inventory/deleteProduct/${product.productId}" />">
		<span class="glyphicon glyphicon-remove"></span></a>
		<a href="<c:url value="/admin/inventory/editProduct/${product.productId}" />">
		<span class="glyphicon glyphicon-pencil"></span></a>
		</td>
	</tr>
	</c:forEach>
</table>

<a class="btn btn-default" href="<c:url value="/admin/inventory/addProduct"/>">Add Product</a>

<%@include file="/WEB-INF/views/common/footer.jsp" %>