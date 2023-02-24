package com.fly.jpa.blog.domain.entity;

import com.fly.jpa.blog.domain.command.CreateBlogCommand;
import com.fly.jpa.common.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Blog extends BaseDomain {
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
}
