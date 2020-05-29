<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
	
	<h1>All Products</h1>
	
	
	<p class="lead">Checkout all products</p>

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
		<td><a href="<spring:url value="/productList/productDetails/${product.productId}" />">
		<span class="glyphicon glyphicon-info-sign"></span></a></td>
	</tr>
	</c:forEach>
</table>

<%@include file="/WEB-INF/views/common/footer.jsp" %>