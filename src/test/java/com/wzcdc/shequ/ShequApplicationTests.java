package com.wzcdc.shequ;

import com.wzcdc.shequ.service.AreaOrgService;
import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.service.SfService;
import com.wzcdc.shequ.service.ZzService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;


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

}
