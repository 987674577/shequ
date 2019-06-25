package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.SfService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param liveCode 登录用户的地区编码
     * @return 待随访条数
     */
    @Override
    public String getCount(String liveCode) {
        return null;
    }
}
