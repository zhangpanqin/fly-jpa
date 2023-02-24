package com.fly.jpa.onetoone2.infrastructure.repository.jpa;

import com.fly.jpa.onetoone2.infrastructure.entity.UsersTwoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersTwoJpaRepository extends JpaRepository<UsersTwoEntity, Long> {
    @Override
    @EntityGraph("users2_with_address2")
    Optional<UsersTwoEntity> findById(Long id);

    @Override
    @EntityGraph("users2_with_address2")
    List<UsersTwoEntity> findAll();
}
