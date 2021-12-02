package com.fly.jpa.blog.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateBlogResponse {
    private Long id;
}
