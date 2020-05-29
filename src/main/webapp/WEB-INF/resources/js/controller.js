var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function (cartId) {
        $http.get('/tomatoesOnTheVine/rest/cart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/tomatoesOnTheVine/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/tomatoesOnTheVine/rest/cart/add/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/tomatoesOnTheVine/rest/cart/cartId'));
            alert("Product successfully added to the cart!")
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/tomatoesOnTheVine/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/tomatoesOnTheVine/rest/cart/cartId'));
        });
    };
});