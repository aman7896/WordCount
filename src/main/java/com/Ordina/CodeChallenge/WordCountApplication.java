package com.Ordina.CodeChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WordCountApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WordCountApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(WordCountApplication.class, args);
	}

}
