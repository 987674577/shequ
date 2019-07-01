package com.wzcdc.shequ.service;

import com.wzcdc.shequ.entity.Patient;

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
     * @param id 个人信息id
     * @return 患者个人信息
     */
    Patient getInfo(String id);


    /**
     * 根据患者身份证号获取个人信息
     *
     * @param cardNo 患者身份证号
     * @return
     */
    Patient getInfoByCardNo(String cardNo);
}
