package com.wzcdc.shequ;

import com.alibaba.fastjson.JSON;
import com.wzcdc.shequ.service.SfService;
import com.wzcdc.shequ.service.ZzService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

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


    @Test
    public void contextLoads() {
        MockHttpSession session = new MockHttpSession();
        Map map = httpUtils.doGet("/wzcdc/rest/tRecordController/get/330327196012274739", session);
        System.out.println(map.get("data"));
    }

}
