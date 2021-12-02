package com.fly.jpa.blog.domain.repository;

import com.fly.jpa.blog.domain.entity.Blog;

public interface BlogRepository {
    Blog save(Blog blog);
}
