package com.wzcdc.shequ.service;

import java.util.Map;

/**
 * 患者信息服务接口
 *
 * @author 刘孝丰
 * @date 2019-06-24 17:19
 */
public interface PatientService {


    /**
     * 根据身份证查询患者个人信息
     *
     * @param idNo 身份证号码
     * @return 患者个人信息
     */
    Map getInfo(String idNo);
}
