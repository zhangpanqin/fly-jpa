package com.fly.jpa.blog.api;

import com.fly.jpa.blog.api.request.CreateBlogRequest;
import com.fly.jpa.blog.api.response.CreateBlogResponse;

public interface BlogApi {
    CreateBlogResponse save(CreateBlogRequest request);
}
