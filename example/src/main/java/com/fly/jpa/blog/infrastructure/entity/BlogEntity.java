package com.fly.jpa.blog.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.io.Serial;

@Getter
@Setter
@Entity
@Table(name = "blog")
@SQLDelete(sql = "UPDATE blog SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
    "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
    check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
public class BlogEntity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    private String title;

    private Long userId;

    private String content;
}
