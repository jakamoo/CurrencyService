package com.profeed.DollarEuroRecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DollarEuroRecorderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DollarEuroRecorderApplication.class, args);

    }

}

