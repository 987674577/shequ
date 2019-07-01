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


    /**
     * 查询待随访列表信息
     * @param data 查询条件
     * @returns {HttpPromise}
     */
    this.sfSearchList = function (data) {
        return $http.post("/shequ/sfdata/list", data);
    };


    /**
     * 第一次随访录入初始化
     * @param id 患者id
     */
    this.sfFirAddInit = function (id) {
        return $http.get("/shequ/sfdata/firInit/" + id);
    };

    /**
     * 随访录入初始化
     * @param id 患者id
     */
    this.sfAddInit = function (id) {
        return $http.get("/shequ/sfdata/init/" + id);
    };


    /**
     * 上传第一次随访数据
     * @param data 新增第一次随访数据
     * @returns {*}
     */
    this.firSfPostData = function (data) {
        return $http.post("/shequ/sfdata/firPostData", data);
    };

    /**
     * 上传随访数据
     * @param data 新增随访数据
     * @returns {*}
     */
    this.sfPostData = function (data) {
        return $http.post("/shequ/sfdata/postData", data);
    };
});