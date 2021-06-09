package com.ssg.people92.jpa_postgresql;

import com.ssg.people92.jpa_postgresql.store.jpo.PaymentJpo;
import com.ssg.people92.jpa_postgresql.store.repository.PaymentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaPostgresqlApplicationTests {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    void sequenceSaveTest() {
        PaymentJpo paymentJpo = new PaymentJpo();
        paymentJpo.setMbrId("TEST1");
        paymentJpo.setPmtCode("TEST1");
        PaymentJpo result = paymentRepository.save(paymentJpo);

        Assertions.assertNotNull(result.getPmtId());
    }

}
