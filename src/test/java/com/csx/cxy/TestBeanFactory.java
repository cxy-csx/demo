package com.csx.cxy;

import com.csx.cxy.entity.Product;
import com.csx.cxy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBeanFactory {


    @Test
    public void test(){
//        Product bean = (Product) BeanFactory.getBean("product");
        User bean = (User) BeanFactory.getBean("user");
        System.out.println(bean);
    }

}
