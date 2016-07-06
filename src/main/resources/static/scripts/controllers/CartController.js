'use strict';
angular.module('shoppingCart').controller('CartController', ['CallFactory', function (CallFactory) {
    var vm = this;
    vm.products = [];
    //vm.productsSearched = false;
    vm.productsMessage = '';

    vm.creatingProduct = false;
    vm.name = '';
    vm.image = '';
    vm.price = 0;

    vm.initialize = function () {
      //if(!vm.productsSearched){
          CallFactory.products().find().$promise.then(function(response){
              vm.products = response;
          },function(error){
              vm.productsMessage = error.statusText;
          });
          //vm.productsSearched = true;
      //}
    };

    (function () {
     vm.initialize();
    })();

    vm.newProduct = function(){
        vm.creatingProduct = true;
    };

     vm.saveProduct = function(){
         var productDto = {
             name: vm.name,
             image: vm.image,
             price: vm.price
         };
        CallFactory.newProduct().save(productDto).$promise.then(function(response){
            vm.initialize();
            vm.creatingProduct = false;
        },function(error){
           vm.productsMessage = error.statusText;
        });
     }
}]);