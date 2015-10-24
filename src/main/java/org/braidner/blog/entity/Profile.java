package org.braidner.blog.entity;

import org.braidner.blog.entity.config.BaseEntity;
import org.braidner.blog.entity.enums.OAuthProvider;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Braidner
 */

@FilterDefs({
        @FilterDef(name = Profile.FILTER_BASIC_LOGIN, parameters = {
                @ParamDef(name = "login", type = "string"),
                @ParamDef(name = "password", type = "string")
        }),
        @FilterDef(name = Profile.FILTER_OAUTH_LOGIN, parameters = {
                @ParamDef(name = "provider", type = "string"),
                @ParamDef(name = "oauthId", type = "string")
        }),
})
@Filters({
        @Filter(name = Profile.FILTER_BASIC_LOGIN, condition = "login = :login and password = :password"),
        @Filter(name = Profile.FILTER_OAUTH_LOGIN, condition = "oauth_provider = :provider and oauth_id = :oauthId")
})
@Entity
@Table(name = "profile")
public class Profile extends BaseEntity {
    public static final String FILTER_BASIC_LOGIN = "FILTER_BASIC_LOGIN";
    public static final String FILTER_OAUTH_LOGIN = "FILTER_OAUTH_LOGIN";

    public Profile() {
    }

    public Profile(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private String login;
    private String password;

    @OneToOne
    private UserInfo userInfo;

    @Transient
    private OAuthProvider provider;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public OAuthProvider getProvider() {
        return provider;
    }

    public void setProvider(OAuthProvider provider) {
        this.provider = provider;
    }
}
