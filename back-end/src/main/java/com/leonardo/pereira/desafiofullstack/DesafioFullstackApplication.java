package com.leonardo.pereira.desafiofullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@SpringBootApplication
public class DesafioFullstackApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFullstackApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/empresa/**")
				.allowedMethods("*")
				.allowedOrigins("*");
	}
}
