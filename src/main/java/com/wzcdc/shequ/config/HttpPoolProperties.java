package com.wzcdc.shequ.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Http连接池配置
 *
 * @author 刘孝丰
 * @date 2019-06-21 14:23
 */
@Component
@ConfigurationProperties(prefix = "http-pool")
@Data
public class HttpPoolProperties {
    /**
     * 最大连接数
     */
    private Integer maxTotal;
    /**
     * 默认的每个路由最大连接数
     */
    private Integer defaultMaxPerRoute;
    /**
     * 连接超时时间
     */
    private Integer connectTimeout;
    /**
     * 从池中获取连接超时时间
     */
    private Integer connectionRequestTimeout;
    /**
     * 等待数据超时时间
     */
    private Integer socketTimeout;
    /**
     * 空闲永久连接检查间隔（检查链接可用性的时间间隔）
     */
    private Integer validateAfterInactivity;
}
