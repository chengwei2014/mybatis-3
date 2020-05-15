package com.v1.mapper;


/**
 * BlogMapper
 * 2020-05-14
 */
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);

}
