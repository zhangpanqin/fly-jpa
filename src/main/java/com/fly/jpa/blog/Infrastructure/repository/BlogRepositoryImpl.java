package com.fly.jpa.blog.Infrastructure.repository;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.Infrastructure.mapper.BlogMapper;
import com.fly.jpa.blog.Infrastructure.repository.jpa.BlogJpaRepository;
import com.fly.jpa.blog.domain.entity.Blog;
import com.fly.jpa.blog.domain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogRepositoryImpl implements BlogRepository {

    private final BlogJpaRepository repository;

    private final BlogMapper blogMapper;

    @Override
    public Blog save(Blog blog) {
        var entity = repository.save(blogMapper.toEntity(blog));
        return blog.assignId(entity.getId());
    }
}
