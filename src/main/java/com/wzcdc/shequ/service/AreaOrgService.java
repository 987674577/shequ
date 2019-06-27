package com.wzcdc.shequ.service;


import com.wzcdc.shequ.entity.Area;
import com.wzcdc.shequ.entity.Org;

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


    /**
     * 根据地区编码获取地区对象
     *
     * @param areaCode 地区编码
     * @return
     */
    Area getArea(String areaCode);


    /**
     * 根据机构编码获取机构对象
     *
     * @param orgCode 机构编码
     * @return
     */
    Org getOrg(String orgCode);
}
