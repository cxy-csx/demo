package com.csx.cxy;

import org.dromara.sms4j.comm.enumerate.SupplierType;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSms {

    @Test
    public void test(){
        SmsFactory.createSmsBlend(SupplierType.TENCENT).sendMessage("15018707754","123456");
    }

}
