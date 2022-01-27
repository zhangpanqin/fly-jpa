package com.fly.jpa.blog;

import cn.hutool.core.collection.CollectionUtil;
import com.fly.jpa.blog.Infrastructure.repository.jpa.BlogJpaRepository;
import com.fly.jpa.blog.api.request.CreateBlogRequest;
import com.fly.jpa.blog.api.response.CreateBlogResponse;
import com.fly.jpa.blog.domain.entity.User;
import com.fly.jpa.blog.service.BlogAppService;
import com.fly.jpa.blog.service.BlogRepresentationService;
import com.fly.jpa.blog.service.mapper.BlogAppMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogAppService service;

    private final BlogRepresentationService representationService;

    private final BlogAppMapper mapper;

    private final BlogJpaRepository repository;

    @PostMapping()
    public CreateBlogResponse save(@RequestBody CreateBlogRequest request) {
        var blog = service.save(mapper.toCommand(request));
        return CreateBlogResponse.builder()
                .id(blog.getId())
                .build();
    }

    @DeleteMapping("/all")
    public String deleteAll() {
        service.deleteAll();
        return "success";
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id) {
        return representationService.findUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteUserById(id);
        return "success";
    }

    @GetMapping("/lock")
    public List<String> testLock() {
        return service.testLock();
    }

    @GetMapping("/test/save")
    @Transactional
    public String testSaveWhenDataNotChange() {
        var all = repository.findAll();

        if (CollectionUtil.isNotEmpty(all)) {
            var entity = all.get(0);
            entity.setTitle("test");
            repository.save(entity);
        }

        return "success";
    }
}
