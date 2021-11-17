package com.emirates.booking.service;

import com.emirates.booking.model.FlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple5;

@Service
public class FlightService {

    @Autowired
    BookingDependentService bds;
    @Autowired
    BookingDependentService1 bds1;
    @Autowired
    BookingDependentService2 bds2;
    @Autowired
    BookingDependentService3 bds3;
    @Autowired
    BookingDependentService4 bds4;

    public Mono<String>  getFlight(FlightRequest flightRequest){
       return this.callDownStreamServices().flatMap(tuple -> {
            return Mono.just("6E-6044");
        });
    }

    public Mono<Tuple5<Boolean, Boolean, Boolean, Boolean, Boolean>> callDownStreamServices() {
        return Mono.zip(bds.getDetails(), bds1.getDetails(), bds2.getDetails(), bds3.getDetails(),
            bds4.getDetails()).subscribeOn(Schedulers.parallel());
    }


}
