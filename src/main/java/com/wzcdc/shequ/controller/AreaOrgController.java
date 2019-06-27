package com.wzcdc.shequ.controller;

import com.wzcdc.shequ.entity.Result;
import com.wzcdc.shequ.service.AreaOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地区机构控制器
 *
 * @author 刘孝丰
 * @date 2019-06-25 14:35
 */
@RequestMapping("/areaOrg")
@RestController
public class AreaOrgController {


    @Autowired
    private AreaOrgService areaOrgService;


    /**
     * 根据登录用户名获取当前登录的医院名称
     *
     * @param username 登录用户名
     * @return
     */
    @GetMapping("/hosName/{username}")
    public Result getHosName(@PathVariable("username") String username) {
        String hosName = areaOrgService.getHosName(username);
        return new Result(hosName);
    }
}
