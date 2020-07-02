package com.delebarre.source.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequiredArgsConstructor
public class RestService {
    private final Source queue;

    @PostMapping("/requests/{requestId}")
    public void getByNameUsingQueues(@NotNull @PathVariable("requestId") String requestId) throws InterruptedException {
        queue.output().send(MessageBuilder.withPayload(requestId).build());
    }
}