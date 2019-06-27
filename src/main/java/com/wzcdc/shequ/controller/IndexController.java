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
import java.util.Map;

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
    @GetMapping("/index")
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
     * @param username 当前登录用户名
     * @return
     */
    @GetMapping("/init/{username}")
    @ResponseBody
    public Result init(@PathVariable("username") String username) {
        HashMap<String, Object> data = new HashMap<>();
        //1.获取当前登录医院名称
        Map<String, String> hosInfo = areaOrgService.getHosInfo(username);
        data.put("hosName", hosInfo.get("fuwujgmc"));
        //2.获取当前登录医院区域代码
        String areaCode = hosInfo.get("mycode");
        data.put("areaCode", areaCode);
        //3.获取追踪待完成数目
        data.put("zzNum", zzService.getCount(areaCode));
        //4.获取随访待完成数目
        data.put("sfNum", sfService.getCount(areaCode));
        return new Result(data);
    }
}
