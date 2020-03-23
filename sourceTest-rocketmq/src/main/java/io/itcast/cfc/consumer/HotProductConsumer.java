package io.itcast.cfc.consumer;

import com.alibaba.fastjson.JSON;
import io.itcast.cfc.mq.HotProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class HotProductConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "jcarttest",groupId = "hot-product-group-id")
    public void hotProduct(String productId){

        logger.info("handle productId:{}",productId);

        JSON.parseObject(productId, HotProductDTO.class)
    }
}
