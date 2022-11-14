package com.ksero.ksero.service;

import com.ksero.kafka.entity.WholesalerDto;
import com.ksero.kafka.service.WholesalerEventsService;
import com.ksero.ksero.domain.model.entity.Wholesaler;
import com.ksero.ksero.domain.persistence.WholesalerRepository;
import com.ksero.ksero.domain.service.WholesalerService;
import com.ksero.shared.exception.ResourceNotFoundException;
import com.ksero.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class WholesalerServiceImpl implements WholesalerService {
    private static final String ENTITY = "Wholesaler";
    private final WholesalerEventsService eventsService;
    private final WholesalerRepository wholesalerRepository;
    private final Validator validator;
    public WholesalerServiceImpl(WholesalerEventsService eventsService, WholesalerRepository wholesalerRepository, Validator validator) {
        this.eventsService = eventsService;
        this.wholesalerRepository = wholesalerRepository;
        this.validator = validator;
    }

    @Override
    public List<Wholesaler> getAll() {
        return wholesalerRepository.findAll();
    }

    @Override
    public Wholesaler getById(Long wholesalerId) {
        return wholesalerRepository.findById(wholesalerId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, wholesalerId));
    }

    @Override
    public Wholesaler getByWholesalerUsername(String wholesalerName){
        return wholesalerRepository.findByUsername(wholesalerName);
    }
    @Override
    public Wholesaler create(Wholesaler wholesaler) {
        Set<ConstraintViolation<Wholesaler>> violations = validator.validate(wholesaler);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return wholesalerRepository.save(wholesaler);
    }

    @Override
    public Wholesaler update(Long wholesalerId, Wholesaler request) {
        Set<ConstraintViolation<Wholesaler>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return wholesalerRepository.findById(wholesalerId).map(wholesaler ->
                        wholesalerRepository.save(wholesaler
                                .withFirstName(request.getFirstName())
                                .withAddress(request.getAddress())
                                .withLastName(request.getLastName())
                                .withBirthday(request.getBirthday())
                                .withPhone(request.getPhone())
                                .withEmail(request.getEmail())
                                .withUsername(request.getUsername())
                                .withPassword(request.getPassword())
                                .withDescription(request.getDescription())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, wholesalerId));
    }

    @Override
    public ResponseEntity<?> delete(Long wholesalerId) {
        return wholesalerRepository.findById(wholesalerId).map(wholesaler -> {
            WholesalerDto wholesalerDto = new WholesalerDto(
                    wholesaler.getId(),wholesaler.getUsername(),wholesaler.getEmail());
            eventsService.publishDelete(wholesalerDto);
            wholesalerRepository.delete(wholesaler);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, wholesalerId));
    }
}
