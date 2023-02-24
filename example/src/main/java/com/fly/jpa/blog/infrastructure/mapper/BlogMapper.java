package com.fly.jpa.blog.infrastructure.mapper;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.domain.entity.Blog;
import com.fly.jpa.common.config.CentralMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface BlogMapper {
    BlogEntity toEntity(Blog blog);
    Blog toDomain(BlogEntity entity);
}
