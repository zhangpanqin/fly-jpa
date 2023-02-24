package com.fly.jpa.onetoone2.infrastructure.mapper;

import com.fly.jpa.onetoone2.domain.UsersTwo;
import com.fly.jpa.onetoone2.infrastructure.entity.UsersTwoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersTwoMapper {
    UsersTwo toUsers(UsersTwoEntity usersEntity);
}
