package com.njy.markets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.njy.markets")
public class MarketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketsApplication.class, args);
	}


}
