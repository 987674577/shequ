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

});