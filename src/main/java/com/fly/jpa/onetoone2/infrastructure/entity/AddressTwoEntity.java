package com.fly.jpa.onetoone2.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "address2")
@ToString(callSuper = true)
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
}

