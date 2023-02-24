package com.fly.jpa.blog.infrastructure.mapper;

import com.fly.jpa.blog.infrastructure.entity.UserEntity;
import com.fly.jpa.blog.domain.entity.User;
import com.fly.jpa.common.config.CentralMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface UserMapper {
    User toUser(UserEntity userEntity);

    UserEntity toEntity(User user);
}
