//集成通用方法
app.controller('baseController', function ($scope) {


    /**
     * 跳转到追踪页面
     * @param username 登录用户名
     * @param areaCode 地区编码
     */
    $scope.gozz = function (username, areaCode) {
        location.href = "/shequ/zz?username=" + username + "&areaCode=" + areaCode;
    };


    /**
     * 跳转到追踪录入页面
     * @param id 个人信息id
     * @param username 登录用户
     */
    $scope.gozzadd = function (id, username) {
        location.href = "/shequ/zz/add?id=" + id + "&username=" + username;
    };


    /**
     * 跳转到随访页面
     * @param username 登录用户名
     * @param areaCode 地区编码
     */
    $scope.gosf = function (username, areaCode) {
        location.href = "/shequ/sf?username=" + username + "&areaCode=" + areaCode;
    };


    /**
     * 跳转到随访录入页面
     * @param cardNo 患者身份证号
     * @param nextDate 下次随访日期
     */
    $scope.gosfadd = function (cardNo, nextDate) {
        if (!nextDate) {
            //下次随访日期为空，跳转到初次录入界面
            location.href = "/shequ/sf/firstAdd?cardNo=" + cardNo;
        } else {
            location.href = "/shequ/sf/add?cardNo=" + cardNo;
        }
    };


    /**
     * 从URL中获取参数
     * @param name URL中参数名
     * @returns {*} 获取到的参数
     */
    $scope.getUrlPara = function (name) {
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    };


    /**
     *  格式化空值的方法
     * @param data 要格式化的数据
     * @returns {string|*}
     */
    $scope.forNull = function (data) {
        if (!data || data.toUpperCase() === "NULL") {
            return "未填写";
        } else {
            return data;
        }
    };

    $scope.forDate = function (dateStr) {
        if (!dateStr || dateStr.toUpperCase() === "NULL") {
            return "未填写";
        } else {
            return dateStr.substring(0, 10);
        }
    };
});