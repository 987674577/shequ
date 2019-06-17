package com.wzcdc.shequ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 刘孝丰
 * @date 2019-06-17 11:03
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
