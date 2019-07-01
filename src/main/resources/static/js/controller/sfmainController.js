//定义随访列表控制层
app.controller('sfmainController', function ($scope, $controller, areaOrgService, patientService) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});

    /**
     * 搜索条件数据
     * @type {string}
     */
    $scope.searchData = {text: "", areaCode: ""};

    /**
     * 搜索栏数据
     * @type {string}
     */
    $scope.searchText = "";

    /**
     * 获取URL中的地区编码
     */
    $scope.searchData.areaCode = $scope.getUrlPara("areaCode");


    /**
     * 获取URL中的登录用户名
     */
    $scope.username = $scope.getUrlPara("username");


    /**
     * 待随访列表
     * @type {Array}
     */
    $scope.list = [];


    /**
     * 当前登录医院名称
     * @type {string}
     */
    $scope.hosName = "";


    /**
     *  搜索列表信息
     */
    $scope.searchList = function () {

        patientService.sfSearchList($scope.searchData).success(function (ressponse) {
            if (ressponse.res) {
                $scope.list = ressponse.data;
            }
        });

    };


    /**
     * 页面初始化方法
     */
    $scope.doInit = function () {

        //加载当前登录医院名称
        areaOrgService.getHosName($scope.username).success(function (response) {
            if (response.res) {
                $scope.hosName = response.data;
            }
        });

        //加载待追踪列表数据
        $scope.searchList();
    };

    /**
     * 监听搜索栏数据变动
     */
    $scope.$watch('searchText', function (newValue, oldValue) {
        //搜索栏去除空格，并填充到搜索条件中
        $scope.searchData.text = $scope.searchText.trim();
    });
    $scope.$watch('searchData.text', function (newValue, oldValue) {
        //开始搜索
        $scope.searchList(true);
    });

});