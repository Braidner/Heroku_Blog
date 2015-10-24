package org.braidner.blog.entity;

import org.braidner.blog.entity.config.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Braidner
 */
@Entity
@Table(name = "authority")
public class Authority extends BaseEntity implements GrantedAuthority {

    private String name;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
