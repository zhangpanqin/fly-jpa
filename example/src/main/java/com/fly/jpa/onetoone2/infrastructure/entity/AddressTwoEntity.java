package com.fly.jpa.onetoone2.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Entity
@Table(name = "address2")
@SQLDelete(sql = "UPDATE address2 SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
        "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
        check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
public class AddressTwoEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String city;

    @Column(name = "user_id")
    private Long userId;

    public void setCity(String city) {
        this.city = city;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

