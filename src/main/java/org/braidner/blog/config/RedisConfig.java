package org.braidner.blog.config;

import org.braidner.blog.redis.listener.EventListener;
import org.braidner.blog.redis.listener.NotifyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author Braidner
 */
@Configuration
public class RedisConfig {

    public static final String REDIS_ENDPOINT = "pub-redis-13429.us-east-1-4.4.ec2.garantiadata.com";
    public static final int REDIS_PORT = 13429;
    public static final int REDIS_TIMEOUT = 1800;
    public static final String REDIS_PASSWORD = "123";


    @Bean
    public Jedis jedisClient() {
        Jedis jedis = new Jedis(REDIS_ENDPOINT, REDIS_PORT, REDIS_TIMEOUT);
        jedis.auth(REDIS_PASSWORD);
        return jedis;
    }

    @Bean
    @Autowired
    public EventListener subscribeToEvents(final Jedis jedisClient, final EventListener eventListener) {
        subscribe(jedisClient, eventListener, "jms/events", "EventSubscription");
        return eventListener;
    }

    @Bean
    @Autowired
    public NotifyListener subscribeToNotifications(final Jedis jedisClient, final NotifyListener notifyListener) {
        subscribe(jedisClient, notifyListener, "jms/notify", "NotifySubscription");
        return notifyListener;
    }

    private void subscribe(Jedis jedisClient, JedisPubSub listener, String channel, String threadName) {
        new Thread(() -> {
            jedisClient.subscribe(listener, channel);
        }, threadName).start();
    }
}
