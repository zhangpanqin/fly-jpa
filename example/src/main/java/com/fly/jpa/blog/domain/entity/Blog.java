package com.fly.jpa.blog.domain.entity;

import com.fly.jpa.blog.domain.command.CreateBlogCommand;
import com.fly.jpa.common.domain.BaseDomain;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Blog extends BaseDomain {
    private String title;
    private String content;
    private Long userId;

    public static Blog create(CreateBlogCommand command, Long userId) {
        return Blog.builder()
            .content(command.getContent())
            .title(command.getTitle())
            .userId(userId)
            .build();
    }
}
