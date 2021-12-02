package com.fly.jpa.blog.api.request;

import lombok.Data;

@Data
public class CreateBlogRequest {
    private String title;
    private String content;
}
