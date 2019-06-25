//定义随访列表控制层
app.controller('sfmainController', function ($scope, $controller, $location) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});


});