package com.fly.jpa.onetoone2.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsersTwo {
    private String username;
    private AddressTwo addressTwo;
}
