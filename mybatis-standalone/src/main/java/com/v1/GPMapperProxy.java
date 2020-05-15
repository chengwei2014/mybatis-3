package com.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * GPMapperProxy
 * 2020-05-14
 */
public class GPMapperProxy implements InvocationHandler {
    private GPSqlSession sqlSession;
    public GPMapperProxy(GPSqlSession gpSqlSession) {
        this.sqlSession = gpSqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface + "." + methodName;
        return sqlSession.selectOne(statementId, args[0]);
    }
}
