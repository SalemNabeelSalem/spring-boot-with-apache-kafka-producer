package com.salemnabeel.kafka.producer.events.payloads;

import com.salemnabeel.kafka.producer.models.UserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EVENT_03_PAYLOAD {

    private String name;

    private String age;

    public EVENT_03_PAYLOAD(UserRequest userRequest) {

        this.name = userRequest.getName();

        this.age = userRequest.getAge();
    }
}
