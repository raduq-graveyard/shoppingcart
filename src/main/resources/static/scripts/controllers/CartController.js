'use strict';
angular.module('shoppingCart').controller('CartController', ['CallFactory', function (CallFactory) {
    var vm = this;
    vm.products = [];
    vm.errorMessage = '';

    vm.cart = {};

    vm.creatingProduct = false;
    vm.newProd = {
        name: '',
        image: '',
        price: ''
    };
    vm.newItemQuantity = 0;

    vm.initialize = function () {
      CallFactory.products().find().$promise.then(function(response){
          vm.products = response.products;
          vm.newProd = {
             name: '',
             image: '',
             price: ''
          };
      },function(error){
          vm.errorMessage = error.statusText;
      });
      CallFactory.shoppingCart().find().$promise.then(function(response)){
        vm.cart = response;
      },function(error){
         vm.errorMessage = error.statusText;
      });
    };

    (function () {
        vm.initialize();
    })();

    vm.newProduct = function(){
        vm.creatingProduct = true;
    };

    vm.saveProduct = function(){
       CallFactory.newProduct().save(vm.newProd).$promise.then(function(response){
           vm.initialize();
           vm.creatingProduct = false;
       },function(error){
           vm.productsMessage = error.statusText;
       });
    }

    vm.addProduct = function(id){
       var itemDto = {
           id: '',
           product_id: id,
           quantity: vm.newItemQuantity,
           amount: ''
       };
       CallFactory.addItem().save(itemDto).$promise.then(function(response){
           vm.initialize();
           vm.newItemQuantity = 0;
       },function(error){
           vm.errorMessage = error.statusText;
       });
    }

}]);