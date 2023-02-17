package com.fly.jpa;

import com.fly.jpa.onetoone2.infrastructure.entity.AddressTwoEntity;
import com.fly.jpa.onetoone2.infrastructure.entity.UsersTwoEntity;
import com.fly.jpa.onetoone2.infrastructure.repository.jpa.AddressTwoJpaRepository;
import com.fly.jpa.onetoone2.infrastructure.repository.jpa.UsersTwoJpaRepository;
import org.hamcrest.Matchers;
import org.hibernate.Session;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.TransactionManager;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;

class UserTwoTest extends BaseIsolationTest {
    @Autowired
    private UsersTwoJpaRepository usersTwoJpaRepository;

    @Autowired
    private AddressTwoJpaRepository addressTwoJpaRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionManager transactionManager;

    @Test
    void name() {
        System.out.println(usersTwoJpaRepository.findById(100L));
    }

    @Test
    void  test(){
        System.out.println(transactionManager.toString());
    }
    @Nested
    class TestSameTransaction1 {

        void before() {
            var usersTwoEntity = new UsersTwoEntity();
            usersTwoEntity.setId(3L);
            usersTwoEntity.setUsername("ceshi");
            var addressTwoEntity = new AddressTwoEntity();
            addressTwoEntity.setUserId(3L);
            addressTwoEntity.setId(3L);
            addressTwoEntity.setCity("ceshi");
            //when
            usersTwoJpaRepository.saveAndFlush(usersTwoEntity);
            addressTwoJpaRepository.saveAndFlush(addressTwoEntity);
        }

        @Test
        void test_same_transaction2() {
            /**
             * 同一个事务不清理 jpa session 缓存
             */

            before();
            //then
            entityManager.clear();
            var byId = usersTwoJpaRepository.findById(3L).get();
            assertThat(byId, Matchers.notNullValue());
            assertThat(byId.getAddressTwo(), Matchers.notNullValue());
        }
    }

    @Nested
    class TestSameTransaction2 {
        @BeforeTransaction
        void before() {
            var usersTwoEntity = new UsersTwoEntity();
            usersTwoEntity.setId(3L);
            usersTwoEntity.setUsername("ceshi");
            var addressTwoEntity = new AddressTwoEntity();
            addressTwoEntity.setUserId(3L);
            addressTwoEntity.setId(3L);
            addressTwoEntity.setCity("ceshi");
            //when
            usersTwoJpaRepository.save(usersTwoEntity);
            addressTwoJpaRepository.save(addressTwoEntity);
        }

        @Test
        void test_same_transaction() {
            /**
             * 不同事物
             * @author 张攀钦
             * @title test_same_transaction
             */
            //then
            var byId = usersTwoJpaRepository.findById(3L).get();
            assertThat(byId, Matchers.notNullValue());
            assertThat(byId.getAddressTwo(), Matchers.notNullValue());
        }
    }

    @Nested
    class TestSameTransaction3 {

        void before2() {
            var usersTwoEntity = new UsersTwoEntity();
            usersTwoEntity.setId(3L);
            usersTwoEntity.setUsername("ceshi");
            var addressTwoEntity = new AddressTwoEntity();
            addressTwoEntity.setUserId(3L);
            addressTwoEntity.setId(3L);
            addressTwoEntity.setCity("ceshi");
            //when
            entityManager.persist(usersTwoEntity);
            entityManager.persist(addressTwoEntity);
//            entityManager.flush();
        }

        @Test
        void test_same_transaction3() {
            //then
            before2();
//            var session = entityManager.unwrap(Session.class);
//            session.clear();
//            var usersTwoEntity = usersTwoJpaRepository.findById(3L).get();
//            assertThat(usersTwoEntity, Matchers.notNullValue());
//            assertThat(usersTwoEntity.getAddressTwo(), Matchers.notNullValue());
        }
    }
}
