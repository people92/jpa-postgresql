package com.ssg.people92.jpa_postgresql.store.jpo;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
* PAYMENT 테이블 PMT_ID 키 생성
* */
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        Connection connection = sharedSessionContractImplementor.connection();
        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select nextval('seq_payment')");

            if(rs.next())
            {
                int id = rs.getInt(1);
                StringBuffer sb = new StringBuffer();

                String generatedId = sb.append("TE").append(id).toString();

                return generatedId;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
