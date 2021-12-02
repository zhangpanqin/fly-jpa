package com.fly.jpa.blog.service;

import com.fly.jpa.blog.domain.command.CreateBlogCommand;
import com.fly.jpa.blog.domain.entity.Blog;
import com.fly.jpa.blog.domain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogAppService {

    private final BlogRepository blogRepository;

    public Blog save(CreateBlogCommand command) {
        var blog = Blog.create(command, 2L);
        return blogRepository.save(blog);
    }
}
