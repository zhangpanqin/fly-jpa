package com.fly.jpa.common.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    public static final String SOFT_DELETED_CLAUSE = "deleted_at = -1";
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @CreatedDate
    @Column(updatable = false)
    private Instant createdDate;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @Column
    @LastModifiedDate
    private Instant lastModifiedDate;

    @Column
    @LastModifiedBy
    private String lastModifiedBy;

    @Column
    @Version
    private Integer version;

    @Column
    private Long deletedAt = -1L;
}
