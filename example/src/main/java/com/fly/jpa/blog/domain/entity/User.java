package com.fly.jpa.blog.domain.entity;

import com.fly.jpa.common.domain.BaseDomain;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import java.util.List;

@Getter
@SuperBuilder
public class User extends BaseDomain {
    private Long id;
    private String name;
    private List<Blog> blogs;
}
