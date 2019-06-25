package com.wzcdc.shequ.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 调用远程接口的工具类
 *
 * @author 刘孝丰
 * @date 2019-06-21 14:20
 */
@Component
public class HttpUtils {
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 远程接口IP
     */
    @Value("${interface.ip}")
    private String ip;

    /**
     * 远程接口用户名
     */
    @Value("${interface.username}")
    private String username;

    /**
     * 远程接口密码
     */
    @Value("${interface.password}")
    private String password;

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 从session中获取token的方法
     *
     * @param session 当前会话的session对象
     * @return token
     */
    private String getToken(HttpSession session) {
        String token = (String) session.getAttribute("token");
        //如果session中没有token值
        if (token == null || "".equals(token.trim())) {
            ResponseEntity<String> res = restTemplate.postForEntity(ip + "/wzcdc/rest/tokens?username=" + username + "&password=" + password, new HashMap<>(), String.class);
            token = res.getBody();
            if (token.equals("用户账号密码错误!")) {
                LOG.error("获取远程接口的token时登录失败！");
            }
            session.setAttribute("token", token);
        }
        return token;
    }


    /**
     * 发送GET请求
     *
     * @param url     请求URL
     * @param session 会话对象
     * @return 响应体
     */
    public Map doGet(String url, HttpSession session) {
        //设置请求头
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("X-AUTH-TOKEN", getToken(session));
        //设置请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        //发送请求，获取响应
        ResponseEntity<Map> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(ip + url, HttpMethod.GET, requestEntity, Map.class);
        } catch (RestClientException e) {
            LOG.error(url + "=====请求失败！=====");
        }
        return responseEntity.getBody();
    }


    /**
     * 发送POST请求
     *
     * @param url     请求URL
     * @param session 会话对象
     * @return 响应体
     */
    public Map doPost(String url, HttpSession session) {
        //设置请求头
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("X-AUTH-TOKEN", getToken(session));
        //设置请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        //发送请求，获取响应
        ResponseEntity<Map> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(ip + url, HttpMethod.POST, requestEntity, Map.class);
        } catch (RestClientException e) {
            LOG.error(url + "=====请求失败！=====");
        }
        return responseEntity.getBody();
    }


    /**
     * 发送POST请求
     *
     * @param url     请求URL
     * @param body    请求体
     * @param session 会话对象
     * @return 响应体
     */
    public Map doPost(String url, Map body, HttpSession session) {
        //设置请求头
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("X-AUTH-TOKEN", getToken(session));
        //设置请求头
        HttpEntity<Map> requestEntity = new HttpEntity<>(body, requestHeaders);
        //发送请求，获取响应
        ResponseEntity<Map> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(ip + url, HttpMethod.POST, requestEntity, Map.class);
        } catch (RestClientException e) {
            LOG.error(url + "=====请求失败！=====");
        }
        return responseEntity.getBody();
    }
}
