package com.fly.jpa.blog.domain.entity;

import com.fly.jpa.blog.domain.command.CreateBlogCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Blog {
    private Long id;
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

    public Blog assignId(Long id) {
        this.id = id;
        return this;
    }
}
