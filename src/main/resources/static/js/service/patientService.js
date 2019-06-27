//获取患者信息的服务层
app.service('patientService', function ($http) {


    /**
     * 查询待追踪列表信息
     * @param data 查询条件
     * @returns {HttpPromise}
     */
    this.zzSearchList = function (data) {
        return $http.post("/shequ/zzdata/list", data);
    };


    /**
     * 追踪录入界面初始化
     */
    this.zzAddInit = function (id, username) {
        return $http.get("/shequ/zzdata/init/" + id + "/" + username);
    };


    /**
     * 上传追踪数据
     * @param data 新增追踪数据
     * @returns {*}
     */
    this.postData = function (data) {
        return $http.post("/shequ/zzdata/postData", data);
    };
});