//定义追踪列表控制层
app.controller('zzmainController', function ($scope, $controller, areaOrgService, patientService) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});

    /**
     * 搜索条件数据
     * @type {string}
     */
    $scope.searchData = {text: "", areaCode: "", page: 1, size: 5};

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
     * 待追踪列表
     * @type {Array}
     */
    $scope.list = [];


    /**
     * 当前登录医院名称
     * @type {string}
     */
    $scope.hosName = "";

    /**
     * 列表是否到底
     * @type {boolean}
     */
    $scope.listOver = false;

    /**
     * 是否正在查询（繁忙）
     * @type {boolean}
     */
    $scope.busy = false;

    /**
     * 页面底部提示列表是否到底
     */
    $scope.makeText = function () {
        if ($scope.listOver) {
            return "已显示全部列表";
        } else {
            return "加载更多列表";
        }
    };


    /**
     *  搜索列表信息
     * @param first 是否是第一次调用方法（初始化调用）
     */
    $scope.searchList = function (first) {

        //列表并没有正在加载也没有加载完全
        if (!$scope.listOver && !$scope.busy) {

            $scope.busy = true;//进入加载状态


            patientService.zzSearchList($scope.searchData).success(function (ressponse) {
                if (ressponse.res) {

                    $scope.searchData.page++;//页码+1
                    if (ressponse.data.length < $scope.searchData.size) {
                        //返回条数不满一页，数据已经加载完全
                        $scope.listOver = true;
                    }

                    if (first) {
                        //第一次加载
                        $scope.list = ressponse.data;
                    } else {
                        //扩充列表加载
                        $scope.list.push(ressponse.data);
                    }
                }
                $scope.busy = false;//完成加载
            });
        }

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
        $scope.searchList(true);
    };


    /**
     * 监听搜索栏数据变动
     */
    $scope.$watch('searchText', function (newValue, oldValue) {
        //搜索栏去除空格，并填充到搜索条件中
        $scope.searchData.text = $scope.searchText.trim();
    });
    $scope.$watch('searchData.text', function (newValue, oldValue) {
        //搜索内容变更时，重新查询
        $scope.listOver = false;//列表到底改为false
        $scope.page = 1;//页码还原为1
        //开始搜索
        $scope.searchList(true);
    });

});