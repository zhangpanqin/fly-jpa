package com.fly.jpa.onetoone2.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import com.fly.jpa.onetoone.infrastructure.entity.AddressEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users2")
@ToString(callSuper = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        UsersTwoEntity that = (UsersTwoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

