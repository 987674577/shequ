package com.wzcdc.shequ.controller;

import com.wzcdc.shequ.entity.Patient;
import com.wzcdc.shequ.entity.Result;
import com.wzcdc.shequ.service.AreaOrgService;
import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.service.PatientService;
import com.wzcdc.shequ.service.SfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    private PatientService patientService;

    @Autowired
    private CodeTableService codeTableService;

    @Autowired
    private AreaOrgService areaOrgService;


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


    /**
     * 第一次随访录入初始化
     *
     * @param id 患者ID
     * @return
     */
    @GetMapping("/firInit/{id}")
    public Result firInit(@PathVariable("id") String id) {
        HashMap<String, Object> data = new HashMap<>();

        //1.获取患者个人基本信息
        Patient info = patientService.getInfo(id);
        data.put("patient", info);

        //2.获取数据字典
        HashMap<String, Object> tables = new HashMap<>();
        tables.put("sffs", codeTableService.getTable("sffs"));//随访方式
        tables.put("hzlx", codeTableService.getTable("hzlx"));//患者类型
        tables.put("tjqk", codeTableService.getTable("jtqk"));//痰菌情况
        tables.put("nyqk", codeTableService.getTable("nyqk"));//耐药情况
        tables.put("zzjtz", codeTableService.getTable("zzjtz"));//症状及体征
        tables.put("yf", codeTableService.getTable("yf"));//用法
        tables.put("ypjx", codeTableService.getTable("ypjx"));//药品剂型
        tables.put("ddry", codeTableService.getTable("jdry"));//督导人员
        tables.put("tfqk", codeTableService.getTable("qk"));//通风情况
        data.put("tables", tables);

        return new Result(data);
    }


    /**
     * 随访录入初始化
     *
     * @param id 患者ID
     * @return
     */
    @GetMapping("/init/{id}")
    public Result init(@PathVariable("id") String id) {
        HashMap<String, Object> data = new HashMap<>();

        //1.获取患者个人基本信息
        Patient info = patientService.getInfo(id);
        data.put("patient", info);

        //2.获取数据字典
        HashMap<String, Object> tables = new HashMap<>();
        tables.put("ddry", codeTableService.getTable("jdry"));//督导人员
        tables.put("sffs", codeTableService.getTable("sffs"));//随访方式
        tables.put("zzjtz", codeTableService.getTable("zzjtz"));//症状及体征
        tables.put("yf", codeTableService.getTable("yf"));//用法
        tables.put("ypjx", codeTableService.getTable("ypjx"));//药品剂型

        data.put("tables", tables);

        return new Result(data);
    }


    /**
     * 新增第一次随访信息
     *
     * @param data 提交数据
     * @return
     */
    @PostMapping("/firPostData")
    public Result firPostData(@RequestBody Map data) {
        Boolean res = sfService.firPostData(data);
        if (res) {
            return new Result("提交成功！");
        } else {
            return new Result(false, "提交失败，请联系管理员");
        }
    }


    /**
     * 新增随访信息
     *
     * @param data 提交数据
     * @return
     */
    @PostMapping("/postData")
    public Result postData(@RequestBody Map data) {
        Boolean res = sfService.postData(data);
        if (res) {
            return new Result("提交成功！");
        } else {
            return new Result(false, "提交失败，请联系管理员");
        }
    }
}
