package com.github.weichun97.generate.autoconfigure;

import com.github.weichun97.generate.autoconfigure.annotations.EnableGenerate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableGenerate
@SpringBootApplication
public class GenerateAutoconfigureApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateAutoconfigureApplication.class, args);
    }

}
