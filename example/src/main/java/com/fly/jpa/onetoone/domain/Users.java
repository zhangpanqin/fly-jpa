package com.fly.jpa.onetoone.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Users {
    private String username;
    private Address address;
}
