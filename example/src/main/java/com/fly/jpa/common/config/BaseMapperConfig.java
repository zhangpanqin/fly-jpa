package com.fly.jpa.common.config;

import com.fly.jpa.common.jpa.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@MapperConfig
public interface BaseMapperConfig<T extends BaseEntity, E> {

    @Mapping(ignore = true, target = "createdBy")
    @Mapping(ignore = true, target = "createdDate")
    @Mapping(ignore = true, target = "lastModifiedBy")
    @Mapping(ignore = true, target = "lastModifiedDate")
    @Mapping(ignore = true, target = "deletedAt")
    T domainToEntity(E source);
}
