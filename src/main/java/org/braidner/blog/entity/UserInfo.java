package org.braidner.blog.entity;

import org.braidner.blog.entity.config.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Braidner
 */
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseEntity {
    private String firstName;
    private String lastName;
    private Date birthDay;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
