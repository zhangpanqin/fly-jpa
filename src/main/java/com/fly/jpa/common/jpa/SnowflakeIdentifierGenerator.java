package com.fly.jpa.common.jpa;

import com.fly.jpa.common.id.SnowflakeGenerate;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SnowflakeIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return SnowflakeGenerate.getId();
    }
}