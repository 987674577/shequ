//获取地区和机构信息的服务层
app.service('areaOrgService', function ($http) {


    /**
     * 获取当前登录医院名称
     * @param username 登录用户名
     * @returns {HttpPromise}
     */
    this.getHosName = function (username) {
        return $http.get("/shequ/areaOrg/hosName/" + username);
    };

});