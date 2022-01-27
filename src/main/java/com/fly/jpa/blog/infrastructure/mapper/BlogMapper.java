package com.fly.jpa.blog.infrastructure.mapper;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.domain.entity.Blog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    BlogEntity toEntity(Blog blog);
}
