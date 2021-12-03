package com.fly.jpa.blog.domain.repository;

import com.fly.jpa.blog.domain.entity.Blog;

import java.util.List;

public interface BlogRepository {
    Blog save(Blog blog);

    void deleteAll();

    List<String> findAllTitleWithLock();
}
