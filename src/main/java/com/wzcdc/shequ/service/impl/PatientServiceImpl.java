package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.entity.Patient;
import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.service.PatientService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private CodeTableService codeTableService;


    /**
     * 根据身份证查询患者个人信息
     *
     * @param id 个人信息id
     * @return 患者个人信息
     */
    @Override
    public Patient getInfo(String id) {
        Map m = (Map) httpUtils.doGet("/wzcdc/rest/tBkllshController/" + id).get("data");
        return new Patient(id,
                m.get("patientName"),
                codeTableService.getTypeName((String) m.get("sex"), "xb"),
                m.get("age"),
                m.get("phone"),
                m.get("cardNo"),
                m.get("addr"),
                m.get("reportUnit"),
                m.get("reportArea")
        );
    }

}
