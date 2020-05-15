package com.v1;

import com.v1.mapper.BlogMapper;

/**
 * 手写MyBatis v1.0测试
 * 2020-05-15
 */
public class Test {
    public static void main(String[] args) {
        GPSqlSession sqlSession = new GPSqlSession(new GPConfiguration(), new GPExecutor());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.selectBlogById(1);
        mapper.selectBlogById(1);
        mapper.selectBlogById(1);
    }
}
