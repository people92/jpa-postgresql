package com.ssg.people92.jpa_postgresql.store.repository;

import com.ssg.people92.jpa_postgresql.store.jpo.PaymentJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PaymentRepository extends JpaRepository<PaymentJpo, String> {
}
