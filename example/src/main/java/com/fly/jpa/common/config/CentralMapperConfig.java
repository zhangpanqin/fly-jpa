package com.fly.jpa.common.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = BaseMapperConfig.class)
public interface CentralMapperConfig {
}
