package com.wzcdc.shequ;

import com.wzcdc.shequ.service.*;
import com.wzcdc.shequ.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShequApplicationTests {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ZzService zzService;

    @Autowired
    private SfService sfService;

    @Autowired
    private AreaOrgService areaOrgService;

    @Autowired
    private CodeTableService codeTableService;

    @Autowired
    private PatientService patientService;


    @Test
    public void contextLoads() {
//        Map<String, String> hosInfo = areaOrgService.getHosInfo("076");
//        System.out.println(hosInfo);
//        Map map = httpUtils.doGet("/wzcdc/rest/tBkllshController/count/33032731");
        HashMap<String, String> map = new HashMap<>();
        map.put("areaCode", "33032731");
        map.put("text", "");
        map.put("page", "1");
        map.put("size", "5");
        List list = zzService.getList(map);
        System.out.println(list);
    }


    @Test
    public void test() {
        System.out.println(codeTableService.getTable("zzzt"));
    }


    @Test
    public void test1() {
//        System.out.println(patientService.getInfo("045B2DE12E13416097EDADF0BB202CD0"));
//        System.out.println(codeTableService.getTable("xb"));
//        System.out.println(httpUtils.doGet("/wzcdc/rest/tBkllshController/" + "045B2DE12E13416097EDADF0BB202CD0").get("data"));
        List<Map<String, String>> data = (List<Map<String, String>>) httpUtils.doGet("/wzcdc/rest/tCdcOrgController/list/" + "330304023").get("data");
        String orgName = data.get(0).get("unitName");
        System.out.println(orgName);
    }

    @Test
    public void test2() {
        System.out.println(areaOrgService.getHosInfo("076"));
    }
}
