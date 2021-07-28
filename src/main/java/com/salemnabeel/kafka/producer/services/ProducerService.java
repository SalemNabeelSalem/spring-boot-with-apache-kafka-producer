package com.salemnabeel.kafka.producer.services;

import com.salemnabeel.kafka.producer.events.GlobalSecureEvent;
import com.salemnabeel.kafka.producer.events.actions.ProducerServiceAction;
import com.salemnabeel.kafka.producer.events.payloads.EVENT_01_PAYLOAD;
import com.salemnabeel.kafka.producer.events.payloads.EVENT_02_PAYLOAD;
import com.salemnabeel.kafka.producer.events.payloads.EVENT_03_PAYLOAD;
import com.salemnabeel.kafka.producer.models.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private StreamBridge streamBridge;

    public UserRequest triggerEvent(Integer id) {

        UserRequest userRequest = new UserRequest();

        switch (id) {
            case 1:
                userRequest.setName("Salem Nabeel");

                userRequest.setAge("23");

                GlobalSecureEvent globalSecureEvent1 = new GlobalSecureEvent(
                    ProducerServiceAction.EVENT_01,
                    new EVENT_01_PAYLOAD(userRequest)
                );

                this.streamBridge.send("uploadProducerEvent-out-0", globalSecureEvent1);

                break;

            case 2:
                userRequest.setName("Abbas Sajad");

                userRequest.setAge("24");

                GlobalSecureEvent globalSecureEvent2 = new GlobalSecureEvent(
                    ProducerServiceAction.EVENT_02,
                    new EVENT_02_PAYLOAD(userRequest)
                );

                this.streamBridge.send("uploadProducerEvent-out-0", globalSecureEvent2);

                break;

            case 3:
                userRequest.setName("Salem Alawi");

                userRequest.setAge("27");

                GlobalSecureEvent globalSecureEvent3 = new GlobalSecureEvent(
                    ProducerServiceAction.EVENT_03,
                    new EVENT_03_PAYLOAD(userRequest)
                );

                this.streamBridge.send("uploadProducerEvent-out-0", globalSecureEvent3);

                break;
        }

        return userRequest;
    }
}