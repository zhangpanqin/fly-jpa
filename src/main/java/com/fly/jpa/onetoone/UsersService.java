package com.fly.jpa.onetoone;

import com.fly.jpa.onetoone.domain.Users;
import com.fly.jpa.onetoone.infrastructure.mapper.UsersMapper;
import com.fly.jpa.onetoone.infrastructure.repository.jpa.UsersJpaRepository;
import com.fly.jpa.onetoone2.domain.UsersTwo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersJpaRepository jpaRepository;
    private final UsersMapper mapper;

    @Transactional(readOnly = true)
    public Users get(Long id) {
        return jpaRepository.findById(id).map(mapper::toUsers)
            .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<Users> all() {
        return jpaRepository.findAll().stream().map(mapper::toUsers).collect(Collectors.toList());
    }

    @Transactional
    public Long save(Users users) {
        return jpaRepository.save(mapper.toEntity(users)).getId();
    }
}
