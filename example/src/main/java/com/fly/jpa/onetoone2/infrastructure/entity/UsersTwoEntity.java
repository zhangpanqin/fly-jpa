package com.fly.jpa.onetoone2.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import java.util.HashMap;
import java.util.Map;

@Getter
@Entity
@Table(name = "users2")
@SQLDelete(sql = "UPDATE users2 SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
    "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
    check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
@NamedEntityGraph(name = "users2_with_address2",
    attributeNodes = @NamedAttributeNode("addressTwo")
)
public class UsersTwoEntity extends BaseEntity {
    private static final long serialVersionUID = -7327279896217322515L;
    @Column
    private String username;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id", referencedColumnName = "user_id", updatable = false, insertable = false)
    private AddressTwoEntity addressTwo;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddressTwo(AddressTwoEntity addressTwo) {
        this.addressTwo = addressTwo;
    }
}

