//定义追踪列表控制层
app.controller('zzmainController', function ($scope, $controller, $location) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});


});