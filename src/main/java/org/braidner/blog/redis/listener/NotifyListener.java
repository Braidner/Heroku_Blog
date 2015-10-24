package org.braidner.blog.redis.listener;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

/**
 * @author Braidner
 */
@Component
public class NotifyListener extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("MESSAGE RECEIVED: " + message);
    }

    @Override
    public void onPMessage(String s, String s1, String s2) {

    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("SUBSCRIBED ON CHANEL: " + channel);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("UNSUBSCRIBED ON CHANEL: " + channel);
    }

    @Override
    public void onPUnsubscribe(String s, int i) {

    }

    @Override
    public void onPSubscribe(String s, int i) {

    }
}
