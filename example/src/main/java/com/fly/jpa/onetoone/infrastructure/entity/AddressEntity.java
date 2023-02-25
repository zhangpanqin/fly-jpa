package com.fly.jpa.onetoone.infrastructure.entity;

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
@Table(name = "address")
@SQLDelete(sql = "UPDATE address SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
        "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
        check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
public class AddressEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String city;

    public void setCity(String city) {
        this.city = city;
    }
}

