package com.fly.jpa.filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DataPermissionJpaRepository<T, ID> extends JpaRepository<T, ID> {
}