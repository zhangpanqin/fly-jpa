package com.fly.jpa.common.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author zhangpanqin
 * @date 2021-04-17-16:02
 */
@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    public static final String SOFT_DELETED_CLAUSE = "deleted_at = -1";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "com.fly.jpa.common.jpa.SnowflakeIdentifierGenerator")
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
    private Integer version = 0;

    @Column
    private Long deletedAt = -1L;
}
