package com.manjora.project.manjora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ManjoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManjoraApplication.class, args);
	}

}
