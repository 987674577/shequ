package com.wzcdc.shequ.entity;

import lombok.Data;

/**
 * 地区
 *
 * @author 刘孝丰
 * @date 2019-06-27 13:48
 */
@Data
public class Area {

    private String areaCode;

    private String areaName;


    public Area(String areaCode, String areaName) {
        this.areaCode = areaCode;
        this.areaName = areaName;
    }
}
