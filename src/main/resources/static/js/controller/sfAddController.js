//定义随访录入控制层
app.controller('sfAddController', function ($scope, $controller, patientService) {


    //继承base控制器
    $controller('baseController', {$scope: $scope});

    /**
     * 获取URL中的患者cardNo
     */
    $scope.cardNo = $scope.getUrlPara("cardNo");


    /**
     * 页面初始化数据
     * @type {{}}
     */
    $scope.data = {};


    /**
     * 提交数据
     * @type {{}}
     */
    $scope.postData = {
        id: $scope.id,
        name: "",
        cardNo: "",
        no: "",
        sfDate: "",
        zlyx: 1,
        ddry: "",
        sffs: "",
        zzjtz: "",
        xy: 0,
        hj: 0,
        zlfa: "",
        yf: "",
        ypjx: "",
        lfyrq: "",
        lfycs: 0,
        ywblfy: "无",
        bfzhhbz: "无",
        kb: "",
        yy: "",
        lznsfjg: "",
        clyj: "",
        xcsfsj: "",
        bz: ""
    };
    $scope.zzjtz = "";
    $scope.ypjx = "";

    $scope.blfy = 1;
    $scope.blfyinfo = "";
    $scope.hbz = 1;
    $scope.hbzinfo = "";

    /**
     * 初始化页面数据
     */
    $scope.doInit = function () {
        patientService.sfAddInit($scope.cardNo).success(function (response) {
            if (response.res) {
                $scope.data = response.data;
                $scope.postData.name = $scope.data.patient.name;
                $scope.postData.cardNo = $scope.data.patient.cardNo;
            }
        });
    };


    /**
     * 数字格式监测
     */
    $scope.$watch('postData.xy', function (newValue, oldValue) {
        if (newValue <= 0) {
            $scope.postData.xy = 0;
        } else if (isNaN(newValue)) {
            $scope.postData.xy = oldValue;
        } else {
            $scope.postData.xy = parseInt(newValue);
        }
    });
    $scope.$watch('postData.hj', function (newValue, oldValue) {
        if (newValue <= 0) {
            $scope.postData.hj = 0;
        } else if (isNaN(newValue)) {
            $scope.postData.hj = oldValue;
        } else {
            $scope.postData.hj = parseInt(newValue);
        }
    });
    $scope.$watch('postData.zlyx', function (newValue, oldValue) {
        if (newValue <= 0) {
            $scope.postData.zlyx = 0;
        } else if (isNaN(newValue)) {
            $scope.postData.zlyx = oldValue;
        } else {
            $scope.postData.zlyx = parseInt(newValue);
        }
    });


    /**
     * 选项监测
     */
    $scope.$watch('blfy', function (newValue, oldValue) {
        if (newValue == 1) {
            $scope.postData.ywblfy = "无";
        }
        if (newValue == 2) {
            $scope.postData.ywblfy = $scope.blfyinfo;
        }
    });
    $scope.$watch('hbz', function (newValue, oldValue) {
        if (newValue == 1) {
            $scope.postData.bfzhhbz = "无";
        }
        if (newValue == 2) {
            $scope.postData.bfzhhbz = $scope.hbzinfo;
        }
    });


    /**
     * 长度监测
     */
    $scope.$watch('blfyinfo', function (newValue, oldValue) {
        if (newValue.length > 32) {
            $scope.blfyinfo = oldValue;
        } else {
            if ($scope.blfy == 2) {
                $scope.postData.ywblfy = newValue;
            }
        }
    });
    $scope.$watch('hbzinfo', function (newValue, oldValue) {
        if (newValue.length > 32) {
            $scope.hbzinfo = oldValue;
        } else {
            if ($scope.hbz == 2) {
                $scope.postData.bfzhhbz = newValue;
            }
        }
    });


    $scope.$watch('postData.lfyrq', function (newValue, oldValue) {
        $scope.postData.lfycs = $scope.postData.lfyrq.split(",").length;
    });


    /**
     * 数据校验
     */
    $scope.check = function () {

        var errMsg = [];

        if ($scope.postData.sfDate == "") {
            errMsg.push("随访日期");
        }

        if ($scope.postData.zlyx < 1) {
            errMsg.push("治疗月序");
        }

        if ($scope.postData.ddry == "") {
            errMsg.push("督导人员");
        }

        if ($scope.postData.sffs == "") {
            errMsg.push("随访方式");
        }

        if ($scope.zzjtz.length < 1) {
            errMsg.push("症状及体征");
        }

        if ($scope.postData.zlfa == "") {
            errMsg.push("化疗方案");
        }

        if ($scope.postData.yf == "") {
            errMsg.push("用法");
        }

        if ($scope.ypjx.length < 1) {
            errMsg.push("药品剂型");
        }

        if ($scope.postData.ywblfy == "") {
            errMsg.push("药物不良反应");
        }

        if ($scope.postData.bfzhhbz == "") {
            errMsg.push("并发症或合并症");
        }

        if ($scope.postData.kb == "") {
            errMsg.push("科别");
        }

        if ($scope.postData.yy == "") {
            errMsg.push("原因");
        }

        if ($scope.postData.lznsfjg == "") {
            errMsg.push("2周内随访结果");
        }

        if ($scope.postData.clyj == "") {
            errMsg.push("处理意见");
        }

        if ($scope.postData.xcsfsj == "") {
            errMsg.push("下次随访时间");
        }

        if ($scope.postData.bz == "") {
            errMsg.push("备注");
        }

        return {res: errMsg.length == 0, err: errMsg.join("、") + "必须正确填写！"}
    };

    /**
     * 数据提交
     */
    $scope.submit = function () {
        var check = $scope.check();
        if (check.res) {
            $scope.postData.zzjtz = $scope.zzjtz.join(",");
            $scope.postData.ypjx = $scope.ypjx.join(",");
            patientService.sfPostData($scope.postData).success(function (response) {
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
            $scope.postData.sfDate = "";
            $scope.postData.sffs = "";
            $scope.postData.hzlx = "";
            $scope.postData.tjqk = "";
            $scope.postData.nyqk = "";
            $scope.postData.zzjtz = "";
            $scope.postData.hlfa = "";
            $scope.postData.yf = "";
            $scope.postData.ypjx = "";
            $scope.postData.ddry = "";
            $scope.postData.tfqk = "";
            $scope.postData.qydd = "";
            $scope.postData.qysj = "";
            $scope.postData.xcsfsj = "";
            $scope.postData.bz = "";
        }
    };
});