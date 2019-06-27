package com.wzcdc.shequ.service;

import java.util.List;
import java.util.Map;

/**
 * 数据字典
 *
 * @author 刘孝丰
 * @date 2019-06-26 17:36
 */
public interface CodeTableService {

    /**
     * 查找数据字典
     *
     * @param tableCode 字典Code
     * @return
     */
    List<Map<String, String>> getTable(String tableCode);
}
