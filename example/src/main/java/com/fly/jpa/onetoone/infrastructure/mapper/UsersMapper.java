package com.fly.jpa.onetoone.infrastructure.mapper;

import com.fly.jpa.common.config.CentralMapperConfig;
import com.fly.jpa.onetoone.domain.Users;
import com.fly.jpa.onetoone.infrastructure.entity.UsersEntity;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface UsersMapper {
    Users toUsers(UsersEntity usersEntity);

    UsersEntity toEntity(Users users);
}
