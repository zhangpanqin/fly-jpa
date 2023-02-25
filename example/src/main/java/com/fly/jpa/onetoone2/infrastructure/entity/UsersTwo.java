package com.fly.jpa.onetoone2.infrastructure.entity;

import lombok.Builder;
import lombok.Getter;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
public class UsersTwo implements Serializable {
    @Serial
    private static final long serialVersionUID = -7327279896217322515L;

    private Long id;

    private String username;

    private AddressTwoEntity addressTwo;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddressTwo(AddressTwoEntity addressTwo) {
        this.addressTwo = addressTwo;
    }
}

