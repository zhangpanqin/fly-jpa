package com.fly.jpa.onetoone.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "users")
@ToString(callSuper = true)
@SQLDelete(sql = "UPDATE users SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
        "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
        check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
@NamedEntityGraph(name = "users_with_address",
        attributeNodes = @NamedAttributeNode("address")
)
public class UsersEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String username;

    @Column
    private Long addressId;

    @OneToOne
    @JoinColumn(name = "addressId", referencedColumnName = "id", insertable = false, updatable = false)
    private AddressEntity address;
}

