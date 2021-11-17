package com.emirates.booking.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PricingService {

    public Mono<String> getPrice() {
        List<String> priceList = getPriceListFromFile();
        Random rand = new Random();
        String randomPrice = priceList.get(rand.nextInt(priceList.size()));
        return Mono.just(randomPrice);
    }

    private List<String> getPriceListFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("prices.txt").getFile());
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
