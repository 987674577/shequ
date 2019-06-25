package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.ZzService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 追踪信息服务接口 实现类
 *
 * @author 刘孝丰
 * @date 2019-06-24 15:20
 */
@Service
public class ZzServiceImpl implements ZzService {


    @Autowired
    private HttpUtils httpUtils;


    /**
     * 获取待追踪条数
     *
     * @param liveCode 登录用户的地区编码
     * @return 待追踪条数
     */
    @Override
    public String getCount(String liveCode) {
        return null;
    }


    @Override
    public List getList(Integer page, Integer size, String liveCode) {
        return null;
    }



}
