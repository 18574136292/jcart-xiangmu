package io.itcast.cfc.dao;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "test01",consumerGroup = "jcart-support-group01")
public class TestRocketMQListener implements RocketMQListener<String> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void onMessage(String str) {
        logger.info("{}", str);
    }
}
