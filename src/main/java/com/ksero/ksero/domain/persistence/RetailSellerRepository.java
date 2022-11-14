package com.ksero.ksero.domain.persistence;

import com.ksero.ksero.domain.model.entity.RetailSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailSellerRepository extends JpaRepository<RetailSeller,Long> {

    RetailSeller findByUsername(String username);
    
}
