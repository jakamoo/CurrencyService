package com.profeed.DollarEuroRecorder;

import com.profeed.DollarEuroRecorder.api.RecordController;
import com.profeed.DollarEuroRecorder.service.RecordService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DollarEuroRecorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarEuroRecorderApplication.class, args);

	}

}
