package com.ksero.ksero.service;

import com.ksero.kafka.entity.RetailsellerDto;
import com.ksero.kafka.service.RetailsellerEventsService;
import com.ksero.ksero.domain.persistence.RetailSellerRepository;
import com.ksero.ksero.domain.service.RetailSellerService;
import com.ksero.shared.exception.ResourceNotFoundException;
import com.ksero.shared.exception.ResourceValidationException;
import com.ksero.ksero.domain.model.entity.RetailSeller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RetailSellerServiceImpl implements RetailSellerService {
    private static final String ENTITY = "RetailSeller";
    private final RetailSellerRepository retailSellerRepository;
    private final RetailsellerEventsService eventsService;
    private final Validator validator;
    public RetailSellerServiceImpl(RetailSellerRepository retailSellerRepository, RetailsellerEventsService eventsService, Validator validator) {
        this.retailSellerRepository = retailSellerRepository;
        this.eventsService = eventsService;
        this.validator = validator;
    }

    @Override
    public List<RetailSeller> getAll() {
        return retailSellerRepository.findAll();
    }

    @Override
    public RetailSeller getById(Long retailSellerId) {
        return retailSellerRepository.findById(retailSellerId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, retailSellerId));
    }

    @Override
    public RetailSeller getByRetailSellerUsername(String retailSellerUsername){
        return retailSellerRepository.findByUsername(retailSellerUsername);
    }

    @Override
    public RetailSeller create(RetailSeller retailSeller) {
        Set<ConstraintViolation<RetailSeller>> violations = validator.validate(retailSeller);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return retailSellerRepository.save(retailSeller);
    }

    @Override
    public RetailSeller update(Long retailSellerId, RetailSeller request) {
        Set<ConstraintViolation<RetailSeller>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return retailSellerRepository.findById(retailSellerId).map(retailSeller ->
                        retailSellerRepository.save(retailSeller
                                .withFirstName(request.getFirstName())
                                .withAddress(request.getAddress())
                                .withLastName(request.getLastName())
                                .withBirthday(request.getBirthday())
                                .withPhone(request.getPhone())
                                .withEmail(request.getEmail())
                                .withUsername(request.getUsername())
                                .withPassword(request.getPassword())
                                .withDescription(request.getDescription())
                                .withPaymentName(request.getPaymentName())
                                .withPaymentPhone(request.getPaymentPhone())
                                .withPaymentEmail(request.getPaymentEmail())
                                .withPaymentCardNumber(request.getPaymentCardNumber())
                                .withPaymentExpirationDate(request.getPaymentExpirationDate())
                                .withPaymentCVV(request.getPaymentCVV())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, retailSellerId));
    }

    @Override
    public ResponseEntity<?> delete(Long retailSellerId) {
        return retailSellerRepository.findById(retailSellerId).map(retailSeller -> {
            RetailsellerDto retailsellerDto = new RetailsellerDto(
                    retailSeller.getId(),retailSeller.getUsername(),retailSeller.getEmail());
            eventsService.publishDelete(retailsellerDto);
            retailSellerRepository.delete(retailSeller);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, retailSellerId));
    }
}
