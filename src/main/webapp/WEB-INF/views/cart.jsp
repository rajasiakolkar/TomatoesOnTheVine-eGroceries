<%@include file="/WEB-INF/views/common/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Your Cart</h1>
					
					<p class="lead">All the products you selected! </p>
				</div>
				
			</div>
		</section>
		<section class="container" ng-app="cartApp">
            <div ng-controller ="cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" click="clearCart()"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                <tr ng-repeat = "item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Final Total</th>
                    <th>{{cart.finalTotal}}</th>
                    <th></th>
                </tr>
            </table>
			<a href="<c:url value="/productList" /> " class="btn btn-default">Shop More!</a>
		</section>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>

<%@include file="/WEB-INF/views/common/footer.jsp"%>