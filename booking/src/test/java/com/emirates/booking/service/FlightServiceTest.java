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
class FlightServiceTest {

    @Mock
    private BookingDependentService bds;
    @Mock
    private BookingDependentService1 bds1;
    @Mock
    private BookingDependentService2 bds2;
    @Mock
    private BookingDependentService3 bds3;
    @Mock
    private BookingDependentService4 bds4;

    @InjectMocks
    private FlightService flightService;


    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFlightTest() {
        when(bds.getDetails()).thenReturn(Mono.just(Boolean.TRUE));
        when(bds1.getDetails()).thenReturn(Mono.just(Boolean.TRUE));
        when(bds2.getDetails()).thenReturn(Mono.just(Boolean.TRUE));
        when(bds3.getDetails()).thenReturn(Mono.just(Boolean.TRUE));
        when(bds4.getDetails()).thenReturn(Mono.just(Boolean.TRUE));
        List<String> airportCodes = Arrays.asList("123","456");
        FlightRequest flightRequest = FlightRequest.builder().date("17-11-2021")
            .airportCodes(airportCodes)
            .build();

        StepVerifier.create(flightService.getFlight(flightRequest))
            .consumeNextWith(response -> {
                assertNotNull(response);
            })
            .verifyComplete();
    }


}
