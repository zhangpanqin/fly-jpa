package com.fly.jpa.blog.service;

import com.fly.jpa.blog.Infrastructure.mapper.UserMapper;
import com.fly.jpa.blog.Infrastructure.repository.jpa.UserJpaRepository;
import com.fly.jpa.blog.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogRepresentationService {

    private final UserJpaRepository userJpaRepository;

    private final UserMapper userMapper;

    @Transactional
    public User findUserById(Long id) {
        return userJpaRepository.findById(id)
                .map(userMapper::toUser)
                .orElse(null);
    }
}
