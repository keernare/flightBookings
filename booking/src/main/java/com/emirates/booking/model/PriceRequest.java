package com.emirates.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceRequest {
    private String flightNumber;
    private String date;
}

