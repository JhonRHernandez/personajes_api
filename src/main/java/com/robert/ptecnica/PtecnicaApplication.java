package com.robert.ptecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PtecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtecnicaApplication.class, args);
	}

}
