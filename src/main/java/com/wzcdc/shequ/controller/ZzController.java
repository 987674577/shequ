package com.wzcdc.shequ.controller;

import com.wzcdc.shequ.entity.Patient;
import com.wzcdc.shequ.entity.Result;
import com.wzcdc.shequ.service.AreaOrgService;
import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.service.PatientService;
import com.wzcdc.shequ.service.ZzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    private PatientService patientService;

    @Autowired
    private CodeTableService codeTableService;

    @Autowired
    private AreaOrgService areaOrgService;


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


    /**
     * 追踪录入页面初始化方法
     *
     * @return
     */
    @GetMapping("/init/{id}/{username}")
    public Result init(@PathVariable("id") String id, @PathVariable("username") String username) {
        HashMap<String, Object> data = new HashMap<>();

        //1.获取患者个人基本信息
        Patient info = patientService.getInfo(id);
        data.put("patient", info);

        //2.获取地区和单位
        Map<String, String> hosInfo = areaOrgService.getHosInfo(username);
        HashMap<String, Object> areaOrg = new HashMap<>();
        areaOrg.put("zzdq", areaOrgService.getArea(hosInfo.get("mycode")));//追踪地区
        areaOrg.put("zzdw", areaOrgService.getOrgList(hosInfo.get("fuwujgbh").substring(0, 6)));//追踪单位
        areaOrg.put("bgdq", areaOrgService.getArea((String) info.getReportArea()));//报告地区
        areaOrg.put("bgdw", areaOrgService.getOrg((String) info.getReportUnit()));//报告单位
        data.put("areaOrg", areaOrg);

        //3.获取数据字典
        HashMap<String, Object> tables = new HashMap<>();
        tables.put("zzzt", codeTableService.getTable("zzzt"));//追踪状态
        tables.put("zzwdwyy", codeTableService.getTable("cbkwdwyy"));//追踪未到位原因
        tables.put("wzzyy", codeTableService.getTable("cbkwzzyy"));//未追踪原因
        data.put("tables", tables);

        return new Result(data);
    }


    /**
     * 新增追踪信息
     *
     * @param data 提交数据
     * @return
     */
    @PostMapping("/postData")
    public Result postData(@RequestBody Map data) {
        Boolean res = zzService.postData(data);
        if (res) {
            return new Result("提交成功！");
        } else {
            return new Result(false, "提交失败，请联系管理员");
        }
    }
}
