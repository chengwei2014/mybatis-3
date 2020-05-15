package com.v1;

import com.v1.mapper.Blog;

import java.sql.*;

/**
 * 执行器
 * 2020-05-14
 */
public class GPExecutor {
    public <T> T query(String sql, Object paramater) {
        Blog blog = new Blog();
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            //执行查询
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(sql, paramater));
            //获取结果集
            while (resultSet.next()){
                int bid = resultSet.getInt("bid");
                String name = resultSet.getString("name");
                int authorId = resultSet.getInt("author_id");
                blog.setBid(bid);
                blog.setName(name);
                blog.setAuthorId(authorId);
            }
            System.out.println(blog);

            //关闭连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) blog;
    }
}
