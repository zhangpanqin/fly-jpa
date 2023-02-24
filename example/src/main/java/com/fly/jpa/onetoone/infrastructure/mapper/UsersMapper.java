package com.fly.jpa.onetoone.infrastructure.mapper;

import com.fly.jpa.onetoone.domain.Users;
import com.fly.jpa.onetoone.infrastructure.entity.UsersEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users toUsers(UsersEntity usersEntity);

    UsersEntity toEntity(Users users);
}
