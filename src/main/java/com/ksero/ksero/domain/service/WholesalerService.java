package com.ksero.ksero.domain.service;

import com.ksero.ksero.domain.model.entity.Wholesaler;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WholesalerService {
    List<Wholesaler> getAll();

    Wholesaler getById(Long wholesalerId);
    Wholesaler getByWholesalerUsername(String wholesalerName);
    Wholesaler create(Wholesaler wholesaler);

    Wholesaler update(Long id, Wholesaler wholesaler);

    ResponseEntity<?> delete(Long wholesalerId);
}
