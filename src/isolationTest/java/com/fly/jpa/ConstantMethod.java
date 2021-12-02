package com.fly.jpa;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;

public class ConstantMethod {

    public static BlogEntity buildBlogEntity() {
        var entity2 = new BlogEntity();
        entity2.setContent("content2");
        entity2.setTitle("string");
        entity2.setUserId(2L);
        return entity2;
    }
}
