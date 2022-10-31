package com.example.kseromicroservicesecurity.ksero.api;

import com.example.kseromicroservicesecurity.entity.Customer;
import com.example.kseromicroservicesecurity.ksero.mapping.WholesalerMapper;
import com.example.kseromicroservicesecurity.ksero.domain.service.WholesalerService;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.CreateWholesalerResource;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.UpdateWholesalerResource;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.WholesalerResource;
import com.example.kseromicroservicesecurity.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "acme")
@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("api/v1/wholesalers")
public class WholesalerController {

    private final CustomerService customerService;
    private final WholesalerService wholesalerService;
    private final WholesalerMapper mapper;

    public WholesalerController(CustomerService customerService, WholesalerService wholesalerService, WholesalerMapper mapper){
        this.customerService = customerService;
        this.wholesalerService = wholesalerService;
        this.mapper = mapper;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('WHOLESALER')")
    public List<WholesalerResource> getAll(){
        return mapper.toResource(wholesalerService.getAll());
    }

    @GetMapping("{wholesalerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('WHOLESALER') or hasRole('RETAIL_SELLER')")
    public WholesalerResource getWholesalerById(@PathVariable Long wholesalerId){
        return mapper.toResource(wholesalerService.getById(wholesalerId));
    }

    @GetMapping("wholesalerUsername/{wholesalerUsername}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER') or hasRole('WHOLESALER')")
    public WholesalerResource getByWholesalerUsername(@PathVariable String wholesalerUsername){
        return mapper.toResource(wholesalerService.getByWholesalerUsername(wholesalerUsername));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('WHOLESALER')")
    public WholesalerResource createWholesaler(@RequestBody CreateWholesalerResource resource){

        return mapper.toResource(wholesalerService.create(mapper.toModel(resource)));
    }

    @PutMapping("{wholesalerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('WHOLESALER')")
    public WholesalerResource updateWholesaler(@PathVariable Long wholesalerId,
                                         @RequestBody UpdateWholesalerResource resource){
        return mapper.toResource(wholesalerService.update(wholesalerId, mapper.toModel(resource)));
    }

    @DeleteMapping("{wholesalerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('WHOLESALER')")
    public ResponseEntity<?> deleteWholesaler(@PathVariable Long wholesalerId){
        Customer customer = new Customer();
        customer.setId(wholesalerId);
        this.customerService.save(customer);
        return wholesalerService.delete(wholesalerId);
    }
}
