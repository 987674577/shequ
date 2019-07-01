package com.wzcdc.shequ.service;

import java.util.List;
import java.util.Map;

/**
 * 随访信息服务接口
 *
 * @author 刘孝丰
 * @date 2019-06-24 15:20
 */
public interface SfService {


    /**
     * 获取待随访条数
     *
     * @param liveCode 登录用户的地区编码
     * @return 待随访条数
     */
    Integer getCount(String liveCode);


    /**
     * 查询待随访列表
     *
     * @param map 查询条件
     * @return
     */
    List getList(Map<String, String> map);


    /**
     * 提交第一次随访信息
     *
     * @param data 提交数据
     * @return
     */
    Boolean firPostData(Map data);


    /**
     * 提交随访信息
     *
     * @param data 提交数据
     * @return
     */
    Boolean postData(Map data);
}
