package com.fly.jpa;

import com.fly.jpa.blog.Infrastructure.entity.Blog1Entity;
import com.fly.jpa.blog.Infrastructure.entity.Blog2Entity;
import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.Infrastructure.entity.User1Entity;
import com.fly.jpa.blog.Infrastructure.entity.User2Entity;
import org.assertj.core.util.Sets;

import static com.fly.jpa.ConstantValue.CONTENT;
import static com.fly.jpa.ConstantValue.CONTENT1;
import static com.fly.jpa.ConstantValue.TITLE;
import static com.fly.jpa.ConstantValue.TITLE1;
import static com.fly.jpa.ConstantValue.USER_NAME;

public class ConstantMethod {

    public static BlogEntity buildBlogEntity() {
        var entity2 = new BlogEntity();
        entity2.setContent("content2");
        entity2.setTitle("string");
        entity2.setUserId(2L);
        return entity2;
    }

    public static User1Entity buildUser1Entity() {
        var entity = new User1Entity();
        entity.setBlogs(Sets.newHashSet());
        entity.setName(USER_NAME);
        return entity;
    }


    public static User2Entity buildUser2Entity() {
        var entity = new User2Entity();
        entity.setBlogs(Sets.newHashSet());
        entity.setName(USER_NAME);
        return entity;
    }

    public static Blog2Entity buildBlog2Entity() {
        var entity = new Blog2Entity();
        entity.setTitle(TITLE);
        entity.setContent(CONTENT);
        return entity;
    }

    public static Blog2Entity buildOtherBlog2Entity() {
        var entity = new Blog2Entity();
        entity.setTitle(TITLE1);
        entity.setContent(CONTENT1);
        return entity;
    }

    public static Blog1Entity buildBlog1Entity() {
        var entity = new Blog1Entity();
        entity.setTitle(TITLE);
        entity.setContent(CONTENT);
        return entity;
    }

    public static Blog1Entity buildOtherBlog1Entity() {
        var entity = new Blog1Entity();
        entity.setTitle(TITLE1);
        entity.setContent(CONTENT1);
        return entity;
    }
}

