package com.ksero.kafka.service;

import com.ksero.kafka.entity.WholesalerDto;
import com.ksero.kafka.events.WholesalerDeletedEvent;
import com.ksero.kafka.events.Event;
import com.ksero.kafka.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class WholesalerEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.user.name:wholesalers}")
    private String topicWholesaler;

    public void publishDelete(WholesalerDto wholesaler) {

        WholesalerDeletedEvent deleted = new WholesalerDeletedEvent();
        deleted.setData(wholesaler);
        deleted.setId(UUID.randomUUID().toString());
        deleted.setType(EventType.DELETED);
        deleted.setDate(new Date());

        this.producer.send(topicWholesaler, deleted);
    }

}
