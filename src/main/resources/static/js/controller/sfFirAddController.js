//定义随访初次录入控制层
app.controller('sfFirAddController', function ($scope, $controller, patientService) {


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
        id: "",
        name: "",
        cardNo: "",
        no: "",
        sfDate: "",
        sfFs: "",
        hzlx: "",
        tjqk: "",
        nyqk: "",
        zzjtz: [],
        hlfa: "",
        yf: "",
        ypjx: [],
        ddry: "",
        ddjs: "1",
        tfqk: "",
        xy: 0,
        yj: 0,
        qydd: "",
        qysj: "",
        jlktx: "1",
        fyffypcf: "1",
        fjhzllc: "1",
        bglfywh: "1",
        blfy: "1",
        zlqjfzct: "1",
        jcfy: "1",
        shxg: "1",
        mqjcz: "1",
        xcsfsj: "",
        bz: ""
    };
    $scope.zzjtz = [];
    $scope.ypjx = [];

    /**
     * 初始化页面数据
     */
    $scope.doInit = function () {
        patientService.sfFirAddInit($scope.cardNo).success(function (response) {
            if (response.res) {
                $scope.data = response.data;
                $scope.postData.id = $scope.data.patient.id;
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
    $scope.$watch('postData.yj', function (newValue, oldValue) {
        if (newValue <= 0) {
            $scope.postData.yj = 0;
        } else if (isNaN(newValue)) {
            $scope.postData.yj = oldValue;
        } else {
            $scope.postData.yj = parseInt(newValue);
        }
    });


    /**
     * 数据校验
     */
    $scope.check = function () {
        var errMsg = [];
        if ($scope.postData.sfDate == "") {
            errMsg.push("随访日期");
        }

        if ($scope.postData.sfFs == "") {
            errMsg.push("随访方式");
        }

        if ($scope.postData.hzlx == "") {
            errMsg.push("患者类型");
        }

        if ($scope.postData.tjqk == "") {
            errMsg.push("痰菌情况");
        }

        if ($scope.postData.nyqk == "") {
            errMsg.push("耐药情况");
        }

        if ($scope.zzjtz.length < 1) {
            errMsg.push("症状及体征");
        }

        if ($scope.postData.hlfa == "") {
            errMsg.push("化疗方案");
        }

        if ($scope.postData.yf == "") {
            errMsg.push("用法");
        }

        if ($scope.ypjx.length < 1) {
            errMsg.push("药品剂型");
        }

        if ($scope.postData.ddry == "") {
            errMsg.push("督导人员");
        }

        if ($scope.postData.tfqk == "") {
            errMsg.push("通风情况");
        }

        if ($scope.postData.qydd == "") {
            errMsg.push("取药地点");
        }

        if ($scope.postData.qysj == "") {
            errMsg.push("取药时间");
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
            patientService.firSfPostData($scope.postData).success(function (response) {
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
            $scope.postData.sfFs = "";
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