package com.wzcdc.shequ.service;

import java.util.List;
import java.util.Map;

/**
 * 追踪信息服务接口
 *
 * @author 刘孝丰
 * @date 2019-06-24 15:19
 */
public interface ZzService {


    /**
     * 获取待追踪条数
     *
     * @param areaCode 登录用户的地区编码
     * @return 待追踪条数
     */
    Integer getCount(String areaCode);


    /**
     * 查询待追踪列表
     *
     * @param map 查询条件
     * @return
     */
    List getList(Map<String, String> map);


    /**
     * 提交新增追踪数据
     *
     * @param data 录入数据
     * @return
     */
    Boolean postData(Map data);
}
