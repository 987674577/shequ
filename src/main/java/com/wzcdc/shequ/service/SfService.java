package com.wzcdc.shequ.service;

/**
 * 随访信息服务接口
 *
 * @author 刘孝丰
 * @date 2019-06-24 15:20
 */
public interface SfService {


    /**
     * 获取待随访条数
     *
     * @param liveCode 登录用户的地区编码
     * @return 待随访条数
     */
    String getCount(String liveCode);
}
