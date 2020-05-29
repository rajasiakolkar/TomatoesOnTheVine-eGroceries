<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">

			<h1>Update Product</h1>


			<p class="lead">Fill in the information below</p>

		</div>

		<form:form action="${pageContext.request.contextPath}/admin/inventory/editProduct" method="post"
                   commandName="products" enctype="multipart/form-data">
        <form:hidden path="productId" value="${product.productId}" />
			<div class="form-group">
				<label for="name">Name:</label>
				<form:input path="productName" id="name" class="form-control" value="${product.productName}" />			
			</div>
			<div class="form-group">
				<label for="category">Category:</label>
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Fruit" />Fruit</label>
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Vegetable" />Vegetable</label>
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Grain" />Grain</label>
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Flour"/>Flour</label>
				<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Oil" />Oil</label>
				
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<form:textarea path="productDescription" id="description" class="form-control" value="${product.productDescription}"/>			
			</div>
			<div class="form-group">
				<label for="price">Price:</label>
				<form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>			
			</div>
			<div class="form-group">
				<label for="status">Status:</label>
				<label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Available" />Available</label>
				<label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Unavailable" />Unavailable</label>
			</div>
			<div class="form-group">
				<label for="numAvailable">Quantity Available:</label>
				<form:input path="productnumAvailable" id="numAvailable" class="form-control" value="${product.productnumAvailable}"/>			
			</div>
			<div class="form-group">
				<label class="control-label" for="image"> Upload </label>
				<form:input path="image" id="image" type="file" class="form:input-large" />			
			</div>
			<hr/>
			<input type="submit" value="submit" class="btn btn-primary">
			<a href="<c:url value="/admin/inventory"/>" class="btn btn-default">Cancel</a>
		</form:form>

		<%@include file="/WEB-INF/views/common/footer.jsp"%>