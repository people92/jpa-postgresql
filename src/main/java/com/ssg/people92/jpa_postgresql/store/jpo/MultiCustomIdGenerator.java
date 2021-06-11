package com.ssg.people92.jpa_postgresql.store.jpo;


import com.ssg.people92.jpa_postgresql.domain.entity.SequencePrefixConstants;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class MultiCustomIdGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        this.prefix = properties.getProperty("prefix");
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        Connection connection = sharedSessionContractImplementor.connection();
        try {
            Statement statement = connection.createStatement();

            String query = "";
            if(SequencePrefixConstants.PAYMENT_KEY.equals(prefix)){
                query = "select nextval('seq_payment')";
            }else if(SequencePrefixConstants.SELLER_KEY.equals(prefix)){
                query = "select nextval('seq_seller')";
            }
            ResultSet rs = statement.executeQuery(query);

            if(rs.next())
            {
                int id = rs.getInt(1);
                StringBuffer sb = new StringBuffer();

                String generatedId = sb.append(prefix).append(id).toString();

                return generatedId;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
