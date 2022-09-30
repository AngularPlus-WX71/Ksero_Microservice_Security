package com.example.kseromicroservicesecurity.service;

import com.example.kseromicroservicesecurity.entity.Customer;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private final CustomerEventsService customerEventsService;

    public CustomerService(CustomerEventsService customerEventsService) {
        super();
        this.customerEventsService = customerEventsService;
    }

    public Customer save(Customer customer) {
        System.out.println("Received " + customer);
        this.customerEventsService.publish(customer);
        return customer;

    }

}