package com.wzcdc.shequ.controller;

import com.wzcdc.shequ.entity.Result;
import com.wzcdc.shequ.service.AreaOrgService;
import com.wzcdc.shequ.service.SfService;
import com.wzcdc.shequ.service.ZzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 目录控制器，将url请求转向目标html
 *
 * @author 刘孝丰
 * @date 2019-06-17 11:03
 */
@Controller
public class IndexController {

    @Autowired
    private ZzService zzService;

    @Autowired
    private SfService sfService;

    @Autowired
    private AreaOrgService areaOrgService;


    /**
     * 主页面
     *
     * @return
     */
    @GetMapping("/")
    public String getIndex() {

        return "index";
    }


    /**
     * 追踪列表页面
     *
     * @return
     */
    @GetMapping("/zz")
    public String getZzMain() {
        return "zz/main";
    }


    /**
     * 追踪录入页面
     *
     * @return
     */
    @GetMapping("/zz/add")
    public String getZzAdd() {
        return "zz/add";
    }


    /**
     * 随访列表页面
     *
     * @return
     */
    @GetMapping("/sf")
    public String getSfMain() {
        return "sf/main";
    }


    /**
     * 随访录入页面
     *
     * @return
     */
    @GetMapping("/sf/add")
    public String getSfAdd() {
        return "sf/add";
    }


    /**
     * 第一次随访录入页面
     *
     * @return
     */
    @GetMapping("/sf/firstAdd")
    public String getSfAdd1() {
        return "sf/first-add";
    }


    /**
     * 初始化首页数据的方法
     *
     * @param liveCode 当前登录地区代码
     * @return
     */
    @GetMapping("/init/{liveCode}")
    @ResponseBody
    public Result init(@PathVariable("liveCode") String liveCode) {
        HashMap<String, Object> data = new HashMap<>();
        //1.通过登陆地区代码获取当前登录医院名称
        data.put("hosName", areaOrgService.getHosName(liveCode));
        //2.获取追踪待完成数目
        data.put("zzNum", zzService.getCount(liveCode));
        //3.获取随访待完成数目
        data.put("sfNum", sfService.getCount(liveCode));
        return new Result(true, data);
    }
}
