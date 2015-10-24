package org.braidner.blog.entity;

import org.braidner.blog.entity.config.BaseEntity;
import org.braidner.blog.entity.enums.OAuthProvider;
import org.hibernate.annotations.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Set;

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
public class Profile extends BaseEntity implements UserDetails {
    public static final String FILTER_BASIC_LOGIN = "FILTER_BASIC_LOGIN";
    public static final String FILTER_OAUTH_LOGIN = "FILTER_OAUTH_LOGIN";

    public Profile() {
    }

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    @OneToOne
    private UserInfo userInfo;

    @ManyToMany
    private Set<Authority> authorities;

    @Transient
    private OAuthProvider provider;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
