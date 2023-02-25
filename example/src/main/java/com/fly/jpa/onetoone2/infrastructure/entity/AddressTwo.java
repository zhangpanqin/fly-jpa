package com.fly.jpa.onetoone2.infrastructure.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressTwo {
    private static final long serialVersionUID = -7327279896217322515L;

    private Long id;

    private String city;

    private Long userId;
}

