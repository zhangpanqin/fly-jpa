package com.fly.jpa.onetoone.infrastructure.repository.jpa;

import com.fly.jpa.onetoone.infrastructure.entity.UsersEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersJpaRepository extends JpaRepository<UsersEntity, Long> {
    @Override
    @EntityGraph("users_with_address")
    Optional<UsersEntity> findById(Long id);

    @Override
    @EntityGraph("users_with_address")
    List<UsersEntity> findAll();
}
