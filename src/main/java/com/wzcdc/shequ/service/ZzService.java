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
     * @param liveCode 登录用户的地区编码
     * @return 待追踪条数
     */
    String getCount(String liveCode);


    /**
     * 获取待追踪列表
     *
     * @param page     当前页
     * @param size     每页条数
     * @param liveCode 登录用户的地区编码
     * @return 待追踪列表
     */
    List getList(Integer page, Integer size, String liveCode);
}