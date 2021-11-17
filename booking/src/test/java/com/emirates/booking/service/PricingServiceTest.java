package com.emirates.booking.service;

import com.emirates.booking.model.FlightRequest;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
class PricingServiceTest {

    @InjectMocks
    private PricingService pricingService;


    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPriceTest() {
        StepVerifier.create(pricingService.getPrice())
            .consumeNextWith(response -> {
                assertNotNull(response);
            })
            .verifyComplete();
    }


}
