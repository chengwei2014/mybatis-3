package com.v1;

/**
 * SqlSession
 * 2020-05-14
 */
public class GPSqlSession {
    private GPConfiguration configuration;
    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T>T selectOne(String statementId, Object paramater){
        String sql = GPConfiguration.sqlMappings.getString(statementId);
        if(null != sql && !"".equals(sql)){
            return executor.query(sql,paramater);
        }
        return null;
    }

    public <T>T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }
}
