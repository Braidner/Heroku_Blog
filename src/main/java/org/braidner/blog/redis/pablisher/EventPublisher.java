package org.braidner.blog.redis.pablisher;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author Braidner
 */
@Component
public class EventPublisher {

//    @Autowired
    private Jedis jedisClient;

    public void publishEvent(String message) {
        jedisClient.publish("jms/events", message);
    }

}
