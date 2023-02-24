package com.fly.jpa.filter;

import com.fly.jpa.common.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serial;

@Getter
@Setter
@Entity
@Table(name = "blog_with_permission")
@SQLDelete(sql = "UPDATE blog_with_permission SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
        "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
        check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
public class BlogWithPermissionEntity extends DataPermission {
    @Serial
    private static final long serialVersionUID = 1L;

    private String title;

    private Long userId;

    private String content;
}
