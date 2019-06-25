package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 患者信息服务接口类
 *
 * @author 刘孝丰
 * @date 2019-06-24 17:19
 */
@Service
public class PatientServiceImpl implements PatientService {

    /**
     * 根据身份证查询患者个人信息
     *
     * @param idNo 身份证号码
     * @return 患者个人信息
     */
    @Override
    public Map getInfo(String idNo) {
        return null;
    }
}
