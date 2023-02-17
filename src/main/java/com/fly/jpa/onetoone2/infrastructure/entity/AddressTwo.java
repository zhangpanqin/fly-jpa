package com.fly.jpa.onetoone2.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Data
public class AddressTwo {
    private static final long serialVersionUID = -7327279896217322515L;

    private Long id;

    private String city;

    private Long userId;
}

