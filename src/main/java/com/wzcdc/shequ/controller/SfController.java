package com.wzcdc.shequ.controller;

import com.wzcdc.shequ.entity.Result;
import com.wzcdc.shequ.service.SfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 随访信息控制器
 *
 * @author 刘孝丰
 * @date 2019-06-26 14:05
 */
@RequestMapping("/sfdata")
@RestController
public class SfController {


    @Autowired
    private SfService sfService;


    /**
     * 查询待随访列表
     *
     * @param map 查询条件
     * @return
     */
    @PostMapping("/list")
    public Result searchList(@RequestBody Map<String, String> map) {
        List list = sfService.getList(map);
        return new Result(list);
    }
}
