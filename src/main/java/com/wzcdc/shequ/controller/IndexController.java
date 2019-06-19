package com.wzcdc.shequ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 目录控制器，将url请求转向目标html
 *
 * @author 刘孝丰
 * @date 2019-06-17 11:03
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }


    @GetMapping("/zz")
    public String getZzMain() {
        return "zz/main";
    }


    @GetMapping("/zz/add")
    public String getZzAdd() {
        return "zz/add";
    }


    @GetMapping("/sf")
    public String getSfMain() {
        return "sf/main";
    }


    @GetMapping("/sf/add")
    public String getSfAdd() {
        return "sf/add";
    }


    /**
     * 测试用，第一次随访记录页面
     *
     * @return
     */
    @GetMapping("/sf/add1")
    public String getSfAdd1() {
        return "sf/first-add";
    }
}
