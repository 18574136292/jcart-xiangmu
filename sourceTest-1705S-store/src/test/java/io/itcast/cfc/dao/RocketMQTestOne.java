package io.itcast.cfc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RocketMQTestOne {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Test
    public void rocketMQTest(){
        String str = "测试rocketMq";
        rocketMQTemplate.convertAndSend("test01",str);
    }
}
