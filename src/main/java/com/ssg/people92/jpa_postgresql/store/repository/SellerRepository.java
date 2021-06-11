package com.ssg.people92.jpa_postgresql.store.repository;

import com.ssg.people92.jpa_postgresql.store.jpo.SellerJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerJpo, String> {
}
