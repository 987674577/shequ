package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.AreaOrgService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 地区和机构服务接口 实现类
 *
 * @author 刘孝丰
 * @date 2019-06-25 10:40
 */
@Service
public class AreaOrgServiceImpl implements AreaOrgService {

    @Autowired
    private HttpUtils httpUtils;


    /**
     * 根据登录用户名获取医院信息
     *
     * @param username 用户名
     * @return 医院信息
     */
    @Override
    public Map<String, String> getHosInfo(String username) {
        Map map = httpUtils.doGet("/wzcdc/rest/lzUserInfoController/find/" + username);
        List<Map<String, String>> data = (List<Map<String, String>>) map.get("data");
        return data.get(0);
    }


    /**
     * 根据登录用户名获取医院名称
     *
     * @param username 用户名
     * @return 医院名称
     */
    @Override
    public String getHosName(String username) {
        return getHosInfo(username).get("fuwujgmc");
    }
}
