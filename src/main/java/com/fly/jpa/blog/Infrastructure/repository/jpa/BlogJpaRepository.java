package com.fly.jpa.blog.Infrastructure.repository.jpa;

import com.fly.jpa.blog.Infrastructure.entity.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogJpaRepository extends JpaRepository<BlogEntity, Long> {
    List<BlogEntity> findAllByTitle(String title, Sort sort);

    Page<BlogEntity> findAllByTitle(String title, Pageable pageable);
}
