
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">

			<h1>Product Details</h1>

		</div>

		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-4">
					<img src="#" alt="image" style="widhth: 100%; height: 300px;" />
				</div>
				<div class="col-md-6">
					<h3>${product.productName}</h3>
					<p>${product.productDescription}</p>
					<p>${product.productCategory}</p>
					<p>${product.productPrice}USD</p>
					<p>Available items: ${product.productnumAvailable}</p>
					
					<c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/productList" />
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large"
                           ng-click="addToCart('${product.productId}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span>Order
                            Now</a>
                        <a class="btn btn-default" href="<c:url value="/cart" />" ><span class="glyphicon glyphicon-hand-right" />View Cart</a>
                    </p>
				</div>
			</div><spring:url value="/cart" />
		</div>
		
	<script src="<c:url value="/resources/js/controller.js" />" > </script> 
		<%@include file="/WEB-INF/views/common/footer.jsp"%>