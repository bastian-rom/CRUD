package com.seb.parrolabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ParrolabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParrolabsApplication.class, args);
	}

}
