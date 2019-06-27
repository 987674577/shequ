package com.wzcdc.shequ.service;


import java.util.Map;

/**
 * 地区和机构服务接口
 *
 * @author 刘孝丰
 * @date 2019-06-25 10:39
 */
public interface AreaOrgService {


    /**
     * 根据登录用户名获取医院信息
     *
     * @param username 用户名
     * @return 医院信息
     */
    Map<String, String> getHosInfo(String username);


    /**
     * 根据登录用户名获取医院名称
     *
     * @param username 用户名
     * @return 医院名称
     */
    String getHosName(String username);
}
