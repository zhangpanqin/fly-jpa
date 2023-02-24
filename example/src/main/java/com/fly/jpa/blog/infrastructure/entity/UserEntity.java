package com.fly.jpa.blog.infrastructure.entity;

import com.fly.jpa.common.jpa.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "user_info")
@SQLDelete(sql = "UPDATE user_info SET deleted_at = EXTRACT(EPOCH FROM NOW()), " +
    "version = version + 1, last_modified_date = current_timestamp WHERE id = ? AND version = ?",
    check = ResultCheckStyle.COUNT)
@Where(clause = BaseEntity.SOFT_DELETED_CLAUSE)
@NamedEntityGraph(name = "userWithBlogs", attributeNodes = @NamedAttributeNode("blogs"))
public class UserEntity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "userId")
    private Set<BlogEntity> blogs;

    public void setName(String name) {
        this.name = name;
    }

    public void setBlogs(Set<BlogEntity> blogs) {
        this.blogs = blogs;
    }
}
