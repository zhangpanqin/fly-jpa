package com.fly.jpa.blog.domain.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBlogCommand {
    private String title;
    private String content;
    private Long userId;
}
