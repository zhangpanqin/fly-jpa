package com.fly.jpa;

import cn.hutool.core.collection.CollectionUtil;
import com.fly.jpa.blog.infrastructure.repository.jpa.User2JpaRepository;
import com.fly.jpa.blog.infrastructure.repository.jpa.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static com.fly.jpa.ConstantMethod.buildBlog2Entity;
import static com.fly.jpa.ConstantMethod.buildUser2Entity;

/**
 * 测试 orphanRemoval
 *
 * @author 张攀钦
 * @title
 */


class UserJpaRepositoryTest extends BaseIsolationTest {

    @Autowired
    private UserJpaRepository repository;

    /**
     * 测试级联删除
     * @author 张攀钦
     * @title test_delete_user
     */
    
    @Test
    void test_delete_user() {
        //given

        //when

        //then

    }
}
