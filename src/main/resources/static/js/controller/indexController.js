//定义主页控制层
app.controller('indexController', function ($scope, $controller, $location, indexService) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});


    //页面展示数据
    $scope.dataInfo = {};


    /**
     * 页面初始化方法
     */
    $scope.doInit = function () {
        //获取URL中的liveCode
        var liveCode = $scope.getUrlPara("liveCode");
        //发送初始化数据请求
        indexService.getInit(liveCode).success(function (response) {
            if (response.res) {
                $scope.dataInfo = response.data;
            }
        });
    };
});