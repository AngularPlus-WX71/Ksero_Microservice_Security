package com.example.kseromicroservicesecurity.events;

import com.example.kseromicroservicesecurity.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerDeletedEvent extends Event<Customer> {
}
