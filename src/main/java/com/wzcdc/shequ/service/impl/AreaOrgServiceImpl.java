package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.AreaOrgService;
import org.springframework.stereotype.Service;

/**
 * 地区和机构服务接口 实现类
 *
 * @author 刘孝丰
 * @date 2019-06-25 10:40
 */
@Service
public class AreaOrgServiceImpl implements AreaOrgService {

    /**
     * 根据地区编码获取医院名称
     *
     * @param liveCode 地区编码
     * @return 医院名称
     */
    @Override
    public String getHosName(String liveCode) {
        return null;
    }
}
