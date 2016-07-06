'use strict';
angular.module('shoppingCart').factory('CallFactory', ['$location','$resource', function ($location,$resource) {
//   var baseUrl =  $location.protocol() + '://' + $location.host() + ':' + $location.port();
   var urls = {
       'PRODUCTS': '/shoppingcart/store/products',
       'NEW_PRODUCT': '/shoppingcart/store/products/new'
   };
   return {
       products: function () {
            return $resource(urls['PRODUCTS'], {}, {find: {method: 'GET', isArray: false}});
       },
       newProduct: function () {
            return $resource(urls['NEW_PRODUCT'], {}, {find: {method: 'POST', isArray: false}});
       }
   }
}]);