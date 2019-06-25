//集成通用的页面跳转方法
app.controller('baseController', function ($scope, $location) {


    /**
     * 跳转到追踪页面
     * @param liveCode 区域代码
     */
    $scope.gozz = function (liveCode) {
        location.href = "/shequ/zz?liveCode=" + liveCode;
    };


    /**
     * 跳转到追踪录入页面
     * @param id 录入患者的身份证号
     */
    $scope.gozzadd = function (id) {
        location.href = "/shequ/zz/add?id=" + id;
    };


    /**
     * 跳转到随访页面
     * @param liveCode 区域代码
     */
    $scope.gosf = function (liveCode) {
        location.href = "/shequ/sf?liveCode" + liveCode;
    };


    /**
     * 跳转到随访录入页面
     * @param id 录入患者的身份证号
     */
    $scope.gosfadd = function (id) {
        location.href = "/shequ/sf/add?id=" + id;
    };


    /**
     * 从URL中获取参数
     * @param name URL中参数名
     * @returns {*} 获取到的参数
     */
    $scope.getUrlPara = function (name) {
        return $location.search()[name];
    }


});