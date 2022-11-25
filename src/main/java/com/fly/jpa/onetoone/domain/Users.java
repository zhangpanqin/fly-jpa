package com.fly.jpa.onetoone.domain;

import lombok.Data;

@Data
public class Users {
    private String username;
    private Address address;
}
