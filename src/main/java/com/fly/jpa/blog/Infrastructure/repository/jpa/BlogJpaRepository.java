package com.fly.jpa.blog.Infrastructure.repository.jpa;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogJpaRepository extends JpaRepository<BlogEntity, Long> {
}
