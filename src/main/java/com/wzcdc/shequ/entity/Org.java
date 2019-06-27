package com.wzcdc.shequ.entity;

import lombok.Data;

/**
 * 机构
 *
 * @author 刘孝丰
 * @date 2019-06-27 13:49
 */
@Data
public class Org {

    private String orgCode;

    private String orgName;


    public Org(String orgCode, String orgName) {
        this.orgCode = orgCode;
        this.orgName = orgName;
    }
}
