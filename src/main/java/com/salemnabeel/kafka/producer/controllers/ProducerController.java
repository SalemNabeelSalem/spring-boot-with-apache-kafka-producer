package com.salemnabeel.kafka.producer.controllers;

import com.salemnabeel.kafka.producer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/event")
    public ResponseEntity triggerEvent(@RequestParam("id") Integer id) {

        return new ResponseEntity(producerService.triggerEvent(id), HttpStatus.OK);
    }
}