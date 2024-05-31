package com.JobPortal.portalms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PortalmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalmsApplication.class, args);
	}

}
