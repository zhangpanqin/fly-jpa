package com.fly.jpa.blog.infrastructure.repository.jpa;

import com.fly.jpa.blog.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
