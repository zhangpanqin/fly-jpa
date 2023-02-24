package com.fly.jpa;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.infrastructure.entity.UserEntity;
import com.fly.jpa.filter.BlogWithPermissionEntity;
import static com.fly.jpa.ConstantValue.USER_ID1;
import static com.fly.jpa.ConstantValue.USER_NAME;

public class ConstantMethod {

    public static BlogEntity buildBlogEntity(long id, long userId) {
        var entity = new BlogEntity();
        entity.setId(id);
        entity.setContent("content2");
        entity.setTitle("string");
        entity.setUserId(userId);
        return entity;
    }

    public static UserEntity buildUserEntity(long id) {
        var entity = new UserEntity();
        entity.setId(id);
        entity.setName(USER_NAME);
        return entity;
    }

    public static BlogWithPermissionEntity buildBlogWithPermissionEntity(long id, long deptId) {
        var entity = new BlogWithPermissionEntity();
        entity.setTitle("title");
        entity.setUserId(USER_ID1);
        entity.setContent("content");
        entity.setDeptId(deptId);
        entity.setId(id);
        return entity;
    }
}

