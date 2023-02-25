package com.fly.jpa.common.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class BaseDomain {
    private Integer version;
    private Long id;
}
