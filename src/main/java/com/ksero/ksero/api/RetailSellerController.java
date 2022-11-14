package com.ksero.ksero.api;

import com.ksero.ksero.resources.retail_seller.RetailSellerResource;
import com.ksero.ksero.resources.retail_seller.UpdateRetailSellerResource;
import com.ksero.ksero.domain.service.RetailSellerService;
import com.ksero.ksero.mapping.RetailSellerMapper;
import com.ksero.ksero.resources.retail_seller.CreateRetailSellerResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "acme")
@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("api/v1/retail-sellers")
public class RetailSellerController {
    private final RetailSellerService retailSellerService;
    private final RetailSellerMapper mapper;

    public RetailSellerController(RetailSellerService retailSellerService, RetailSellerMapper mapper){
        this.retailSellerService = retailSellerService;
        this.mapper = mapper;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER')")
    public List<RetailSellerResource> getAll(){
        return mapper.toResource(retailSellerService.getAll());
    }

    @GetMapping("{retailSellerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER') or hasRole('WHOLESALER')")
    public RetailSellerResource getRetailSellerById(@PathVariable Long retailSellerId){
        return mapper.toResource(retailSellerService.getById(retailSellerId));
    }

    @GetMapping("retailSellerUsername/{retailSellerUsername}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER') or hasRole('WHOLESALER')")
    public RetailSellerResource getByRetailSellerUsername(@PathVariable String retailSellerUsername){
        return mapper.toResource(retailSellerService.getByRetailSellerUsername(retailSellerUsername));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER')")
    public RetailSellerResource createRetailSeller(@RequestBody CreateRetailSellerResource resource){
        return mapper.toResource(retailSellerService.create(mapper.toModel(resource)));
    }

    @PutMapping("{retailSellerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER')")
    public RetailSellerResource updateRetailSeller(@PathVariable Long retailSellerId,
                                                   @RequestBody UpdateRetailSellerResource resource){
        return mapper.toResource(retailSellerService.update(retailSellerId, mapper.toModel(resource)));
    }

    @DeleteMapping("{retailSellerId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RETAIL_SELLER')")
    public ResponseEntity<?> deleteRetailSeller(@PathVariable Long retailSellerId){
        return retailSellerService.delete(retailSellerId);
    }
}
