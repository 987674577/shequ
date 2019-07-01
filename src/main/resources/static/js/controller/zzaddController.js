//定义追踪列表控制层
app.controller('zzaddController', function ($scope, $controller, patientService) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});

    /**
     * 获取URL中的患者id
     */
    $scope.id = $scope.getUrlPara("id");

    /**
     * 获取URL中的登录用户名
     */
    $scope.username = $scope.getUrlPara("username");

    /**
     * 页面初始化数据
     * @type {{}}
     */
    $scope.data = {};

    /**
     * 上传数据
     * @type {{trackDate: string, trackWdwReason: string, trackBz: string, reportArea: string, noTrackReason: string, reportUnit: string, jzDate: string, trackArea: string, trackUnit: string}}
     */
    $scope.postData = {
        id: $scope.id,
        trackArea: "",
        trackUnit: "",
        reportArea: "",
        reportUnit: "",
        trackDate: "",
        trackWdwReason: "",
        noTrackReason: "",
        jzDate: "",
        trackBz: ""
    };


    /**
     * 追踪状态
     * @type {number}
     */
    $scope.zzzt = 0;


    /**
     * 初始化页面数据
     */
    $scope.doInit = function () {
        patientService.zzAddInit($scope.id, $scope.username).success(function (response) {
            if (response.res) {
                $scope.data = response.data;
                $scope.postData.trackArea = $scope.data.areaOrg.zzdq.areaCode;
                $scope.postData.reportArea = $scope.data.areaOrg.bgdq.areaCode;
                $scope.postData.reportUnit = $scope.data.areaOrg.bgdw.orgCode;
            }
        });
    };


    /**
     * 监听到位状态
     */
    $scope.$watch('zzzt', function (newValue, oldValue) {
        if (newValue == 0) {
            $scope.postData.trackWdwReason = "";
        } else if (newValue == 1) {
            $scope.postData.noTrackReason = "";
        } else if (newValue == 2) {
            $scope.postData.trackWdwReason = "";
            $scope.postData.noTrackReason = "";
        }
    });

    /**
     * 数据校验
     */
    $scope.check = function () {
        var errMsg = [];
        if ($scope.postData.trackUnit == "") {
            errMsg.push("追踪单位");
        }

        if ($scope.postData.trackDate == "") {
            errMsg.push("追踪日期");
        }

        if ($scope.zzzt == 0 && $scope.postData.noTrackReason == "") {
            errMsg.push("未追踪原因");
        } else if ($scope.zzzt == 1 && $scope.postData.trackWdwReason == "") {
            errMsg.push("追踪未到位原因");
        }

        if ($scope.postData.trackBz == "") {
            errMsg.push("追踪信息备注");
        }

        return {res: errMsg.length == 0, err: errMsg.join("、") + "必须填写！"}
    };

    /**
     * 数据提交
     */
    $scope.submit = function () {
        var check = $scope.check();
        if (check.res) {
            patientService.postData($scope.postData).success(function (response) {
                if (response.res) {
                    alert(response.data);
                    window.history.back(-1);
                } else {
                    alert(response.errMsg);
                }
            });
        } else {
            alert(check.err);
        }
    };

    /**
     * 页面数据重置
     */
    $scope.reset = function () {
        if (confirm("确定重置页面吗？")) {
            $scope.postData.trackDate = "";
            $scope.zzzt = 0;
            $scope.postData.noTrackReason = "";
            $scope.postData.jzDate = "";
            $scope.postData.trackBz = "";
        }
    };
});