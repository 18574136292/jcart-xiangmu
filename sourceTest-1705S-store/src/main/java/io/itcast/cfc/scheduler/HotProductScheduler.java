package io.itcast.cfc.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HotProductScheduler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Scheduled(fixedDelay = 30*1000)
    public void removeHotProduct(){
        logger.info("remove hot product");
        String key = "HotProduct";
        Boolean delete = redisTemplate.delete(key);
    }
}
