package org.braidner.blog.entity.enums;

/**
 * Created by Braidner on 9/8/2015.
 */
public enum OAuthProvider {
    GOOGLE("google"), MICROSOFT("microsoft"), FACEBOOK("facebook"), TWEETER("tweeter");

    OAuthProvider(String param) {
        this.param = param;
    }

    public String param;
}
