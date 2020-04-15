package com.mathif92.testservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.mathif92.testservice")
public class TestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServiceApplication.class, args);
	}

	@Autowired
	RefreshEndpoint refreshEndpoint;

	@Scheduled(initialDelay = 30000, fixedRateString = "30000")
	public void scheduledMethod () {
		try {
			log.info("Refreshing configuration");
			refreshEndpoint.refresh();
		} catch (Exception ex) {
			log.warn("Error refreshing configuration");
		}
	}

}
