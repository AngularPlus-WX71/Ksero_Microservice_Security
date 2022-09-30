package com.example.kseromicroservicesecurity.ksero.domain.service;

import com.example.kseromicroservicesecurity.ksero.domain.model.entity.RetailSeller;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetailSellerService {
    List<RetailSeller> getAll();
    RetailSeller getById(Long retailSellerId);
    RetailSeller getByRetailSellerUsername(String retailSellerUsername);
    RetailSeller create(RetailSeller retailSeller);
    RetailSeller update(Long id, RetailSeller retailSeller);
    ResponseEntity<?> delete(Long retailSellerId);
}
