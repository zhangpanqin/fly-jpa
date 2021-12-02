package com.fly.jpa.blog.domain.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlogCommand {
    private String title;
    private String content;
    private Long userId;
}
