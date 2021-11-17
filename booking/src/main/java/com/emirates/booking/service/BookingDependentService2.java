package com.emirates.booking.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookingDependentService2 {

    public Mono<Boolean> getDetails() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Mono.just(Boolean.TRUE);
    }
}
