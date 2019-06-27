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

    /**
     * 返回状态
     */
    private Boolean res = true;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 错误原因
     */
    private String errMsg;


    public Result() {
    }


    /**
     * 成功传回数据
     *
     * @param data 返回数据
     */
    public Result(Object data) {
        this.data = data;
    }


    /**
     * 失败传回原因
     *
     * @param res    返回状态
     * @param errMsg 错误原因
     */
    public Result(Boolean res, String errMsg) {
        this.res = res;
        this.errMsg = errMsg;
    }
}
