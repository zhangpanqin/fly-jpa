package com.fly.jpa.onetoone2.infrastructure.repository.jpa;

import com.fly.jpa.onetoone2.infrastructure.entity.AddressTwoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTwoJpaRepository extends JpaRepository<AddressTwoEntity, Long> {
}
