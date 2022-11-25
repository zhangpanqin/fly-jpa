package com.fly.jpa.onetoone2;

import com.fly.jpa.onetoone2.domain.UsersTwo;
import com.fly.jpa.onetoone2.infrastructure.mapper.UsersTwoMapper;
import com.fly.jpa.onetoone2.infrastructure.repository.jpa.UsersTwoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersTwoService {
    private final UsersTwoJpaRepository jpaRepository;
    private final UsersTwoMapper mapper;

    @Transactional(readOnly = true)
    public UsersTwo get(Long id) {
        return jpaRepository.findById(id).map(mapper::toUsers)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<UsersTwo> all() {
        return jpaRepository.findAll().stream().map(mapper::toUsers).collect(Collectors.toList());
    }
}