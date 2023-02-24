package com.fly.jpa.blog.infrastructure.repository.jpa;

import com.fly.jpa.blog.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    @EntityGraph("userWithBlogs")
    List<UserEntity> findAllByIdIn(Collection<Long> id);
}
