package com.fly.jpa.common.domain;

import lombok.Getter;

@Getter
public abstract class BaseDomain {
    protected Integer version;
    public void setVersion(Integer version) {
        this.version = version;
    }
}
