package com.wzcdc.shequ.entity;

import lombok.Data;

/**
 * 病人个人信息
 *
 * @author 刘孝丰
 * @date 2019-06-27 11:06
 */
@Data
public class Patient {

    /**
     * id
     */
    private Object id;

    /**
     * 姓名
     */
    private Object name;

    /**
     * 性别
     */
    private Object sex;

    /**
     * 年龄
     */
    private Object age;

    /**
     * 联系电话
     */
    private Object phone;

    /**
     * 身份证号
     */
    private Object cardNo;

    /**
     * 居住地址
     */
    private Object addr;

    /**
     * 上报单位
     */
    private Object reportUnit;

    /**
     * 上报地区
     */
    private Object reportArea;


    public Patient(Object id, Object name, Object sex, Object age, Object phone, Object cardNo, Object addr, Object reportUnit, Object reportArea) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.cardNo = cardNo;
        this.addr = addr;
        this.reportUnit = reportUnit;
        this.reportArea = reportArea;
    }
}
