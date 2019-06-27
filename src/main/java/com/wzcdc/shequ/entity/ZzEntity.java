package com.wzcdc.shequ.entity;

import lombok.Data;

/**
 * 追踪列表信息实体类
 *
 * @author 刘孝丰
 * @date 2019-06-26 17:07
 */
@Data
public class ZzEntity {

    /**
     * 姓名
     */
    private Object name;

    /**
     * 身份证
     */
    private Object id;

    /**
     * 上次追踪日期
     */
    private Object date;

    /**
     * 上次追踪情况
     */
    private Object info;

    /**
     * 未到位原因
     */
    private Object reason;


    public ZzEntity(Object name, Object id, Object date, Object info, Object reason) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.info = info;
        this.reason = reason;
    }
}
