'use strict';
angular.module('shoppingCart').factory('CallFactory', ['$location','$resource', function ($location,$resource) {
//   var baseUrl =  $location.protocol() + '://' + $location.host() + ':' + $location.port();
   var urls = {
       'PRODUCTS': '/shoppingcart/store/products',
       'NEW_PRODUCT': '/shoppingcart/store/products/new',
       'SHOPPING_CART' : '/shoppingcart/cart/shoppingcart',
       'DELETE_ITEM' : '/shoppingcart/cart/shoppingcart/items/',
       'ADD_ITEM': '/shoppingcart/cart/shoppingcart/items'
   };
   return {
       products: function () {
            return $resource(urls['PRODUCTS'], {}, {find: {method: 'GET', isArray: false}});
       },
       newProduct: function () {
            return $resource(urls['NEW_PRODUCT'], {}, {save: {method: 'POST', isArray: false}});
       },
       shoppingCart: function () {
            return $resource(urls['SHOPPING_CART'], {}, {find: {method: 'GET', isArray: false}});
       },
       deleteItem: function (id) {
            return $resource(urls['DELETE_ITEM'] + id, {}, {exec: {method: 'DELETE'}});
       },
       addItem : function () {
            return $resource(urls['ADD_ITEM'], {}, {save: {method: 'POST', isArray: false}});
       }
   }
}]);