package com.csx.cxy;


import com.csx.cxy.http.GaoDeHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
public class TestGaoDeHttp {

    @Resource
    GaoDeHttpClient gaoDeHttpClient;

    @Test
    public void test(){
        Map location = gaoDeHttpClient.getLocation();
        System.out.println(location);
    }


}
