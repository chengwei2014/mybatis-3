package com.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 配置类
 * 2020-05-14
 */
public class GPConfiguration {
    public static final ResourceBundle sqlMappings;
    static {
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }
    public <T> T getMapper(Class clazz, GPSqlSession gpSqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz}, new GPMapperProxy(gpSqlSession));
    }
}
