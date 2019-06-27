package com.wzcdc.shequ.controller;

import com.wzcdc.shequ.entity.Result;
import com.wzcdc.shequ.service.ZzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 追踪信息控制器
 *
 * @author 刘孝丰
 * @date 2019-06-26 10:08
 */
@RequestMapping("/zzdata")
@RestController
public class ZzController {

    @Autowired
    private ZzService zzService;


    /**
     * 查询待追踪列表
     *
     * @param map 查询条件
     * @return
     */
    @PostMapping("/list")
    public Result searchList(@RequestBody Map<String, String> map) {
        List list = zzService.getList(map);
        return new Result(list);
    }
}
