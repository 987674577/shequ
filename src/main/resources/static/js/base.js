//定义模块
var app = angular.module('shequ', []);
app.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode(true);
}]);