package com.wzcdc.shequ.service;

/**
 * 地区和机构服务接口
 *
 * @author 刘孝丰
 * @date 2019-06-25 10:39
 */
public interface AreaOrgService {


    /**
     * 根据liveCode获取医院名称
     *
     * @param liveCode 地区编码
     * @return 医院名称
     */
    String getHosName(String liveCode);
}
