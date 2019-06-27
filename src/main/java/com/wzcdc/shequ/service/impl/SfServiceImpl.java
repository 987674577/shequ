package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.SfService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 随访信息服务接口 实现类
 *
 * @author 刘孝丰
 * @date 2019-06-24 15:23
 */
@Service
public class SfServiceImpl implements SfService {


    @Autowired
    private HttpUtils httpUtils;


    /**
     * 获取待随访条数
     *
     * @param areaCode 登录用户的地区编码
     * @return 待随访条数
     */
    @Override
    public Integer getCount(String areaCode) {
        return (Integer) httpUtils.doGet("/wzcdc/rest/tRecordController/count/" + areaCode).get("data");
    }


    /**
     * 查询待随访列表
     *
     * @param map 查询条件
     * @return
     */
    @Override
    public List getList(Map<String, String> map) {
        return null;
    }
}
