package com.fly.jpa.onetoone2.infrastructure.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersTwo implements Serializable {
    private static final long serialVersionUID = -7327279896217322515L;

    private Long id;

    private String username;

    private AddressTwoEntity addressTwo;
}

