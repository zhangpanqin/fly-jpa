package com.fly.jpa.session;

import com.fly.jpa.BaseIsolationTest;
import com.fly.jpa.blog.infrastructure.entity.UserEntity;
import com.fly.jpa.blog.infrastructure.repository.jpa.UserJpaRepository;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

import static com.fly.jpa.ConstantMethod.buildBlogEntity;
import static com.fly.jpa.ConstantMethod.buildUserEntity;

public class SessionTest extends BaseIsolationTest {
    public static final long USER_ID = 2L;

    @Autowired
    private UserJpaRepository jpaRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    void save() {
        var userEntity = buildUserEntity(USER_ID);
        var blogEntity = buildBlogEntity(1L, USER_ID);
        userEntity.setBlogs(Set.of(blogEntity));
        jpaRepository.save(userEntity);
    }

    @Test
    void update() {
        var userEntity = buildUserEntity(USER_ID);
        var blogEntity = buildBlogEntity(1L, USER_ID);
        userEntity.setBlogs(Sets.newLinkedHashSet(blogEntity));
        jpaRepository.save(userEntity);


        var blogEntity2 = buildBlogEntity(2L, USER_ID);
        userEntity.setBlogs(Sets.newLinkedHashSet(blogEntity2));
        System.out.println("1111111111111111111111111111");
        jpaRepository.save(userEntity);
    }

    @Test
    void delete() {
        var userEntity = buildUserEntity(USER_ID);
        var blogEntity = buildBlogEntity(1L, USER_ID);
        var blogEntity2 = buildBlogEntity(2L, USER_ID);
        userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
        jpaRepository.save(userEntity);
        System.out.println("1111111111111111111111111111");
        jpaRepository.deleteById(USER_ID);
    }


    @Nested
    class refresh {
        @BeforeTransaction
        void before() {
            var userEntity = buildUserEntity(USER_ID);
            var blogEntity = buildBlogEntity(1L, USER_ID);
            var blogEntity2 = buildBlogEntity(2L, USER_ID);
            userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
            jpaRepository.save(userEntity);
        }

        @Test
        @Transactional
        void refresh() throws InterruptedException {
            var userEntity = jpaRepository.findById(USER_ID).get();
            System.out.println("1111111111111111111111111111");
            entityManager.refresh(userEntity);
            System.out.println(userEntity);
        }
    }


    @Nested
    class Select {
        @BeforeTransaction
        void before() {
            var userEntity = buildUserEntity(USER_ID);
            var blogEntity = buildBlogEntity(1L, USER_ID);
            var blogEntity2 = buildBlogEntity(2L, USER_ID);
            userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
            jpaRepository.save(userEntity);
            jpaRepository.save(buildUserEntity(3L));
        }

        @Test
        @Transactional
        void select() {
            jpaRepository.findAll().forEach(System.out::println);
        }
    }

    @Nested
    class Select2 {
        @BeforeTransaction
        void before() {
            var userEntity = buildUserEntity(USER_ID);
            var blogEntity = buildBlogEntity(1L, USER_ID);
            var blogEntity2 = buildBlogEntity(2L, USER_ID);
            userEntity.setBlogs(Set.of(blogEntity, blogEntity2));
            jpaRepository.save(userEntity);
            jpaRepository.save(buildUserEntity(3L));
        }

        @Test
        @Transactional
        void select() {
            jpaRepository.findAllByIdIn(List.of(2L, 3l)).forEach(System.out::println);
        }
    }
}
