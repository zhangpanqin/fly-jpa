package com.fly.jpa.blog.infrastructure.repository.jpa;

import com.fly.jpa.blog.infrastructure.entity.BlogEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogJpaRepository extends JpaRepository<BlogEntity, Long> {
    List<BlogEntity> findAllByTitle(String title, Sort sort);
}
