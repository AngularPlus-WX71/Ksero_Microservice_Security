package com.ksero.ksero.domain.persistence;

import com.ksero.ksero.domain.model.entity.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler,Long> {
    Wholesaler findByUsername(String username);
}
