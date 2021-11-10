package com.vodafone.iot.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.vodafone.iot.tracker" })
public class VodafoneConsumerIotV2Application {

	public static void main(String[] args) {
		SpringApplication.run(VodafoneConsumerIotV2Application.class, args);
	}

}
