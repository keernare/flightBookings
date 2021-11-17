package com.emirates.booking.endpoint;

import com.emirates.booking.model.FlightRequest;
import com.emirates.booking.model.PriceRequest;
import com.emirates.booking.service.FlightService;
import com.emirates.booking.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/emirates")
public class BookingEndpoint {

    @Autowired
    FlightService flightService;

    @Autowired
    PricingService pricingService;

    @GetMapping(path = "/flight", consumes = APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> getFlights(@RequestBody @Valid FlightRequest flightRequest){
        return flightService.getFlight(flightRequest);
    }

    @GetMapping(path = "/price", consumes = APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> getPrice(@RequestBody @Valid PriceRequest priceRequest){
      return   pricingService.getPrice();
    }
}
