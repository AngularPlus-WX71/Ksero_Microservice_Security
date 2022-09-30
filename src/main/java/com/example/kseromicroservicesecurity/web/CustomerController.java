package com.example.kseromicroservicesecurity.web;

import com.example.kseromicroservicesecurity.entity.Customer;
import com.example.kseromicroservicesecurity.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "acme")
@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }


}