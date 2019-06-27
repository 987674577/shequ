package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 字典表服务 实现类
 *
 * @author 刘孝丰
 * @date 2019-06-26 17:36
 */
@Service
public class CodeTableServiceImpl implements CodeTableService {

    @Autowired
    private HttpUtils httpUtils;

    /**
     * 存储字典表
     */
    private Map<String, List<Map<String, String>>> tables = new HashMap<>();


    /**
     * 根据字典表名获取该字典表
     *
     * @param tableCode 字典Code
     * @return
     */
    @Override
    public List<Map<String, String>> getTable(String tableCode) {
        //从缓存中获取字典表
        List<Map<String, String>> table = tables.get(tableCode);
        if (table == null) {
            //缓存中没有该字典表，发送请求获取
            List<Map<String, String>> data = (List<Map<String, String>>) httpUtils.doGet("/wzcdc/rest/systemController/list/zzzt").get("data");
            //将字典表根据状态码排序
            Collections.sort(data, Comparator.comparingInt(o -> Integer.parseInt(o.get("typecode"))));
            table = data;
            //将字典码存入缓存
            tables.put(tableCode, table);
        }
        return table;
    }


    /**
     * 根据状态码和字典表代码获取状态名称
     *
     * @param typeCode  状态码
     * @param tableCode 字典表代码
     * @return
     */
    @Override
    public String getTypeName(String typeCode, String tableCode) {
        List<Map<String, String>> table = getTable(tableCode);
        String typeName = null;
        for (Map<String, String> map : table) {
            if (map.get("typecode").equals(typeCode)) {
                typeName = map.get("typename");
                break;
            }
        }
        return typeName;
    }
}
