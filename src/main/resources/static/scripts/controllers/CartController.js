'use strict';
angular.module('shoppingCart').controller('CartController', ['CallFactory', function (CallFactory) {
    var vm = this;
    vm.products = [];
    vm.productsMessage = '';

    vm.creatingProduct = false;
    vm.newProd = {
        name: '',
        image: '',
        price: ''
    };

    vm.initialize = function () {
      CallFactory.products().find().$promise.then(function(response){
          vm.products = response.products;
          vm.newProd = {
             name: '',
             image: '',
             price: ''
          };
      },function(error){
          vm.productsMessage = error.statusText;
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
}]);