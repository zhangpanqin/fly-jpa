package com.fly.jpa.blog.service.mapper;

import com.fly.jpa.blog.api.request.CreateBlogRequest;
import com.fly.jpa.blog.domain.command.CreateBlogCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogAppMapper {

   CreateBlogCommand toCommand(CreateBlogRequest request);
}
