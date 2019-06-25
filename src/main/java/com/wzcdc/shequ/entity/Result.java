package com.wzcdc.shequ.entity;

import lombok.Data;

/**
 * 请求返回类
 *
 * @author 刘孝丰
 * @date 2019-06-25 10:28
 */
@Data
public class Result {

    private Boolean res;

    private Object data;

    private String msg;


    public Result() {
    }


    /**
     * 成功传回数据
     *
     * @param res  请求状态
     * @param data 返回数据
     */
    public Result(Boolean res, Object data) {
        this.res = res;
        this.data = data;
    }


    /**
     * 失败传回原因
     *
     * @param res 请求状态
     * @param msg 错误原因
     */
    public Result(Boolean res, String msg) {
        this.res = res;
        this.msg = msg;
    }
}
