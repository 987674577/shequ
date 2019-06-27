//获取首页数据的服务层
app.service('indexService', function ($http) {

    /**
     *  获取首页初始化数据
     * @param username
     * @returns {HttpPromise}
     */
    this.getInit = function (username) {
        return $http.get("/shequ/init/" + username);
    };

});