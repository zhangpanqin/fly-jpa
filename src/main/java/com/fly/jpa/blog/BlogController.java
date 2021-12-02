package com.fly.jpa.blog;

import com.fly.jpa.blog.api.request.CreateBlogRequest;
import com.fly.jpa.blog.api.response.CreateBlogResponse;
import com.fly.jpa.blog.service.BlogAppService;
import com.fly.jpa.blog.service.mapper.BlogAppMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogAppService service;

    private final BlogAppMapper mapper;

    @PostMapping()
    public CreateBlogResponse save(@RequestBody CreateBlogRequest request) {
        var blog = service.save(mapper.toCommand(request));
        return CreateBlogResponse.builder()
                .id(blog.getId())
                .build();
    }
}
