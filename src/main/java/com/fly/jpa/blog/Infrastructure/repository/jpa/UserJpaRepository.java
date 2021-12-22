package com.fly.jpa.blog.Infrastructure.repository.jpa;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import com.fly.jpa.blog.Infrastructure.entity.BlogEntity_;
import com.fly.jpa.blog.Infrastructure.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
