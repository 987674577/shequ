//获取首页数据的服务层
app.service('indexService', function ($http) {

    /**
     *  获取首页初始化数据
     * @param liveCode
     * @returns {HttpPromise}
     */
    this.getInit = function (liveCode) {
        return $http.get("/shequ/init/" + liveCode);
    };

});