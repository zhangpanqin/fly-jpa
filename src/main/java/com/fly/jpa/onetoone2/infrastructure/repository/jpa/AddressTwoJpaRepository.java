package com.fly.jpa.onetoone2.infrastructure.repository.jpa;

import com.fly.jpa.onetoone2.infrastructure.entity.AddressTwoEntity;
import com.fly.jpa.onetoone2.infrastructure.entity.UsersTwoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressTwoJpaRepository extends JpaRepository<AddressTwoEntity, Long> {
}
