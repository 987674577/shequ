package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.entity.ZzEntity;
import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.service.ZzService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private CodeTableService codeTableService;


    /**
     * 获取待追踪条数
     *
     * @param areaCode 登录用户的地区编码
     * @return 待追踪条数
     */
    @Override
    public Integer getCount(String areaCode) {
        return (Integer) httpUtils.doGet("/wzcdc/rest/tBkllshController/count/" + areaCode).get("data");
    }


    /**
     * 查询待追踪列表
     *
     * @param map 查询条件
     * @return
     */
    @Override
    public List getList(Map<String, String> map) {
        StringBuffer buffer = new StringBuffer("/wzcdc/rest/tBkllshController/find?");
        buffer.append("areacode=").append(map.get("areaCode")).append("&");
        buffer.append("name=").append(map.get("text")).append("&");
        buffer.append("page=").append(map.get("page")).append("&");
        buffer.append("size=").append(map.get("size"));
        Map res = httpUtils.doPost(buffer.toString());
        List<Map> data = (List<Map>) res.get("data");


        ArrayList<ZzEntity> list = new ArrayList<>();
        data.forEach(o -> {
            list.add(new ZzEntity(
                    o.get("patientName"),
                    o.get("cardNo"),
                    o.get("zzdate"),
                    codeTableService.getTypeName((String) o.get("zzzt"), "zzzt"),
                    o.get("reason")
            ));
        });
        return list;
    }


}
