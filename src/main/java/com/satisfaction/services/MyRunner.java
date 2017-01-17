package com.satisfaction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Created by cov-127 on 17/1/17.
 */
@Service
public class MyRunner implements CommandLineRunner{
    @Value("${dataFilePath:src/main/resources/data.txt}")
    private String dataFilePath;

    @Autowired
    private SatisfactionService satisfactionService;

    @Override
    public void run(String... args) throws Exception {
        long maxValue = satisfactionService.getMaxSatisfactionValue(dataFilePath);
        System.out.println("=== Max satisfaction value is: " + maxValue);
    }
}
