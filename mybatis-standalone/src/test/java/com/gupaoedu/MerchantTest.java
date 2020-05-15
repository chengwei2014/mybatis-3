package com.gupaoedu;

import com.gupaoedu.domain.Blog;
import com.gupaoedu.domain.Merchant;
import com.gupaoedu.mapper.MerchantMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 商户测试
 * 2020-05-07
 */
public class MerchantTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resouce = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resouce);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testQuery(){
        SqlSession session = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = session.getMapper(MerchantMapper.class);
        List<Merchant> merchants = merchantMapper.selectMerchants();
        for (Merchant m:merchants){
            System.out.println("查询结果：" + m.toString());
        }

        //关闭连接
        session.close();
    }

    @Test
    public void insertMerchant(){
        SqlSession session = sqlSessionFactory.openSession();
        MerchantMapper merchantMapper = session.getMapper(MerchantMapper.class);

        Merchant merchant = new Merchant();
        merchant.setName("光明");
        ArrayList<Integer> products = new ArrayList<>();
        products.add(1);
        products.add(2);
        products.add(3);
        merchant.setProduct(products);

        int count = merchantMapper.insertMerchant(merchant);
        session.commit();
        System.out.println("保存成功条数：" + count);

        //关闭连接
        session.close();
    }
}
