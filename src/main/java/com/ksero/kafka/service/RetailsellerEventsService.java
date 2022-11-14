package com.ksero.kafka.service;

import com.ksero.kafka.entity.RetailsellerDto;
import com.ksero.kafka.events.RetailSellerDeletedEvent;
import com.ksero.kafka.events.Event;
import com.ksero.kafka.events.EventType;
import com.ksero.ksero.domain.model.entity.RetailSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class RetailsellerEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.user.name:retailsellers}")
    private String topicRetailseller;

    public void publishDelete(RetailsellerDto retailSeller) {

        RetailSellerDeletedEvent deleted = new RetailSellerDeletedEvent();
        deleted.setData(retailSeller);
        deleted.setId(UUID.randomUUID().toString());
        deleted.setType(EventType.DELETED);
        deleted.setDate(new Date());

        this.producer.send(topicRetailseller, deleted);
    }

}