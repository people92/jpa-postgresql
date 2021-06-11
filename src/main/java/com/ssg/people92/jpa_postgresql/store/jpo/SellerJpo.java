package com.ssg.people92.jpa_postgresql.store.jpo;

import com.ssg.people92.jpa_postgresql.domain.entity.SequencePrefixConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SELLER")
@NoArgsConstructor
@Getter
@Setter
public class SellerJpo extends AuditJpo{

    @Id
    @Column(name = "SELLER_ID")
    @GeneratedValue(generator = "sellerId-generator")
    @GenericGenerator(name = "sellerId-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = SequencePrefixConstants.SELLER_KEY),
            strategy = "com.ssg.people92.jpa_postgresql.store.jpo.MultiCustomIdGenerator")
    private String sellerId;

    @Column(name = "NAME")
    private String name;
}
