package com.emirates.booking.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookingDependentService3 {

    public Mono<Boolean> getDetails() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Mono.just(Boolean.TRUE);
    }
}
