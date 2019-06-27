package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.entity.Area;
import com.wzcdc.shequ.entity.Org;
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


    /**
     * 根据地区编码获取地区对象
     *
     * @param areaCode 地区编码
     * @return
     */
    @Override
    public Area getArea(String areaCode) {
        List<Map<String, String>> data = (List<Map<String, String>>) httpUtils.doGet("/wzcdc/rest/tAddrController/list/" + areaCode).get("data");
        String areaName = null;
        try {
            areaName = data.get(0).get("memo");
        } catch (Exception e) {
            areaName = "未找到";
        }
        return new Area(areaCode, areaName);
    }


    /**
     * 根据机构编码获取机构对象
     *
     * @param orgCode 机构编码
     * @return
     */
    @Override
    public Org getOrg(String orgCode) {
        List<Map<String, String>> data = (List<Map<String, String>>) httpUtils.doGet("/wzcdc/rest/tCdcOrgController/list/" + orgCode).get("data");
        String orgName = null;
        try {
            orgName = data.get(0).get("unitName");
        } catch (Exception e) {
            orgName = "未找到";
        }
        return new Org(orgCode, orgName);
    }

    public List<Org> getOrgList(String orgCode){
        return null;
    }
}
