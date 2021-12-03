package com.fly.jpa.blog.service;

import com.fly.jpa.blog.domain.command.CreateBlogCommand;
import com.fly.jpa.blog.domain.entity.Blog;
import com.fly.jpa.blog.domain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogAppService {

    private final BlogRepository repository;


    public Blog save(CreateBlogCommand command) {
        var blog = Blog.create(command, 2L);
        return repository.save(blog);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    @Transactional
    public List<String> testLock() {
        return repository.findAllTitleWithLock();
    }
}
