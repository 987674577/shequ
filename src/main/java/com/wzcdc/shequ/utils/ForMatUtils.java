package com.wzcdc.shequ.utils;

import java.util.Map;
import java.util.Set;

/**
 * 数据格式化工具
 *
 * @author 刘孝丰
 * @date 2019-06-24 17:33
 */
public class ForMatUtils {


    /**
     * 将集合中的null格式化为未填写
     *
     * @param map 数据集合
     * @return
     */
    public static Map nullFormat(Map map) {
        Set set = map.keySet();
        for (Object o : set) {
            if (map.get(o) == null) {
                map.put(o, "未填写");
            }
        }
        return map;
    }
}
