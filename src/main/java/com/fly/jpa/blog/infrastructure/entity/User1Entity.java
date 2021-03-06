package com.fly.jpa.blog.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user_info1")
@ToString(callSuper = true)
@SQLDelete(sql = "UPDATE user_info1 SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
        "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
        check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
public class User1Entity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String name;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "userId", updatable = false)
    private Set<Blog1Entity> blogs;
}
