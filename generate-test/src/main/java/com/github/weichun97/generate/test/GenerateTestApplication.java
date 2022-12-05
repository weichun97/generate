package com.github.weichun97.generate.test;

import com.github.weichun97.generate.autoconfigure.annotations.EnableGenerate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableGenerate
@SpringBootApplication
public class GenerateTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateTestApplication.class, args);
	}

}
