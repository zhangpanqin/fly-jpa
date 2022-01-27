package com.fly.jpa.blog.infrastructure.mapper;

import com.fly.jpa.blog.infrastructure.entity.UserEntity;
import com.fly.jpa.blog.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserEntity userEntity);
}
