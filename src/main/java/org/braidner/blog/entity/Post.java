package org.braidner.blog.entity;

import org.braidner.blog.entity.config.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Braidner
 */
@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    private String title;
    private String description;

    @ManyToOne
    private Profile author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getAuthor() {
        return author;
    }

    public void setAuthor(Profile author) {
        this.author = author;
    }
}
