package com.fly.jpa;

import cn.hutool.core.collection.CollectionUtil;
import com.fly.jpa.blog.infrastructure.repository.jpa.User1JpaRepository;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.BeforeTransaction;

import java.util.Set;

import static com.fly.jpa.ConstantMethod.buildBlog1Entity;
import static com.fly.jpa.ConstantMethod.buildUser1Entity;

/**
 * 测试 orphanRemoval
 *
 * @author 张攀钦
 * @title
 */

class User1JpaRepositoryTest extends BaseIsolationTest {

    @Autowired
    private User1JpaRepository repository;

    /**
     * @JoinColumn(referencedColumnName = "id", name = "userId", updatable = true)
     * 保存 user1Entity 的时候,顺便将 blog1 中的 userId 也更新补全了
     * 当 updatable = false 的时候,更新 blog1 中的 userId
     */
    @Test
    void should_save_user_and_blog() {
        var all = repository.findAll();
    }

    @Test
    void should_delete_a_log_when_remove_form_set() {
        var all = repository.findAll();
        if (CollectionUtil.isNotEmpty(all)) {
            var user1Entity = all.get(0);
            user1Entity.getBlogs().remove(user1Entity.getBlogs());
//            repository.saveAndFlush(user1Entity);
            repository.delete(user1Entity);
        }
        System.out.println(repository.findAll());
    }

    @BeforeEach
    void before() {
        var user1Entity = buildUser1Entity();
        user1Entity.setBlogs(Sets.set(buildBlog1Entity()));
        repository.save(user1Entity);
    }
}
