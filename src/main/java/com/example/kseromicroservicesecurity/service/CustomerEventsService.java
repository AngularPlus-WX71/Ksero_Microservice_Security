package com.example.kseromicroservicesecurity.service;


import com.example.kseromicroservicesecurity.entity.Customer;
import com.example.kseromicroservicesecurity.events.CustomerCreatedEvent;
import com.example.kseromicroservicesecurity.events.CustomerDeletedEvent;
import com.example.kseromicroservicesecurity.events.Event;
import com.example.kseromicroservicesecurity.events.EventType;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.CreateWholesalerResource;
import com.example.kseromicroservicesecurity.ksero.resources.wholesaler.WholesalerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")
    private String topicCustomer;

    public void publish(Customer customer) {
        // show in console
        System.out.println("Publishing " + customer);

        CustomerCreatedEvent created = new CustomerCreatedEvent();
        created.setData(customer);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);
    }

    public void delete(Customer customer) {
        // show in console
        System.out.println("Deleting " + customer);

        CustomerDeletedEvent deleted = new CustomerDeletedEvent();
        deleted.setData(customer);
        deleted.setId(UUID.randomUUID().toString());
        deleted.setType(EventType.DELETED);
        deleted.setDate(new Date());

        this.producer.send(topicCustomer, deleted);
    }


}
