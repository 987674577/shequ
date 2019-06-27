package com.wzcdc.shequ.utils;

import java.util.List;
import java.util.Map;

/**
 * 数据字典结果查询工具类
 *
 * @author 刘孝丰
 * @date 2019-06-26 17:44
 */
public class SelectUtils {


    /**
     * 从字典表中找出状态码对应名称
     *
     * @param typecode 状态码
     * @param table    状态表
     * @return
     */
    public static String selectForCode(String typecode, List<Map<String, String>> table) {
        String typename = null;
        for (Map<String, String> map : table) {
            if (map.get("typecode").equals(typecode)) {
                typename = map.get("typename");
                break;
            }
        }
        return typename;
    }
}
