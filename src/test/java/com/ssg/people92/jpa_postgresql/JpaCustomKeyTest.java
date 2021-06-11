package com.ssg.people92.jpa_postgresql;

import com.ssg.people92.jpa_postgresql.store.jpo.PaymentJpo;
import com.ssg.people92.jpa_postgresql.store.jpo.SellerJpo;
import com.ssg.people92.jpa_postgresql.store.repository.PaymentRepository;
import com.ssg.people92.jpa_postgresql.store.repository.SellerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaCustomKeyTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Test
    void savePaymentCustomKeyTest() {
        PaymentJpo paymentJpo = new PaymentJpo();
        paymentJpo.setMbrId("TEST1");
        paymentJpo.setPmtCode("TEST1");
        PaymentJpo result = paymentRepository.save(paymentJpo);

        Assertions.assertNotNull(result.getPmtId());
        Assertions.assertEquals(result.getPmtId().substring(0,2), "PM");
    }
    @Test
    void saveSellerCustomKeyTest() {
        SellerJpo sellerJpo = new SellerJpo();
        sellerJpo.setName("TEST1");
        SellerJpo result = sellerRepository.save(sellerJpo);

        Assertions.assertNotNull(result.getSellerId());
        Assertions.assertEquals(result.getSellerId().substring(0,2), "SE");
    }
}
