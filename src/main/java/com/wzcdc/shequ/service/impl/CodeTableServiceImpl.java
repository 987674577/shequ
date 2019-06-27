package com.wzcdc.shequ.service.impl;

import com.wzcdc.shequ.service.CodeTableService;
import com.wzcdc.shequ.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author 刘孝丰
 * @date 2019-06-26 17:36
 */
@Service
public class CodeTableServiceImpl implements CodeTableService {

    @Autowired
    private HttpUtils httpUtils;


    @Override
    public List<Map<String, String>> getTable(String tableCode) {
        List<Map<String, String>> data = (List<Map<String, String>>) httpUtils.doGet("/wzcdc/rest/systemController/list/zzzt").get("data");
        Collections.sort(data, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return Integer.parseInt(o1.get("typecode")) - Integer.parseInt(o2.get("typecode"));
            }
        });
        return data;
    }
}
