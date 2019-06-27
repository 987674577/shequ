//定义主页控制层
app.controller('indexController', function ($scope, $controller, indexService) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});


    //页面展示数据
    $scope.dataInfo = {};

    //从URL获取当前登录用户名
    $scope.username = $scope.getUrlPara("username");


    /**
     * 页面初始化方法
     */
    $scope.doInit = function () {
        //发送初始化数据请求
        indexService.getInit($scope.username).success(function (response) {
            if (response.res) {
                $scope.dataInfo = response.data;
            }
        });
    };

    /**
     * 根据时间获取当前标题
     * @returns {string}
     */
    $scope.getTime = function () {
        var hour = new Date().getHours();
        if (hour < 6) {
            return "为时尚早";
        } else if (hour < 9) {
            return "新的一天，早安";
        } else if (hour < 12) {
            return "上午好";
        } else if (hour < 14) {
            return "中午好";
        } else if (hour < 17) {
            return "下午好";
        } else if (hour < 19) {
            return "归来黄昏后";
        } else if (hour < 22) {
            return "晚上好";
        } else {
            return "夜深了";
        }
    };
});