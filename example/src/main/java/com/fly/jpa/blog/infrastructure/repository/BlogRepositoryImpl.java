package com.fly.jpa.blog.infrastructure.repository;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.infrastructure.mapper.BlogMapper;
import com.fly.jpa.blog.infrastructure.repository.jpa.BlogJpaRepository;
import com.fly.jpa.blog.domain.entity.Blog;
import com.fly.jpa.blog.domain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BlogRepositoryImpl implements BlogRepository {

    private final BlogJpaRepository repository;

    private final BlogMapper blogMapper;

    @Override
    public Blog save(Blog blog) {
        return blogMapper.toDomain(repository.save(blogMapper.toEntity(blog)));
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<String> findAllTitleWithLock() {
        return repository.findAll()
            .stream()
            .map(BlogEntity::getTitle)
            .collect(Collectors.toList());
    }
}
