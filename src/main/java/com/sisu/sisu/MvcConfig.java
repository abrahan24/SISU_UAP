package com.sisu.sisu;

import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
    
    private final Logger log = LoggerFactory.getLogger(getClass());

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// 	WebMvcConfigurer.super.addResourceHandlers(registry);

	// 	String resourcePath = Paths.get("Proyecto/uploads").toAbsolutePath().toUri().toString();
	// 	log.info(resourcePath);
	// 	System.out.println("LA DIRECCION ES: "+resourcePath);
	// 	registry.addResourceHandler("/Proyecto/uploads/**")
	// 	.addResourceLocations(resourcePath);
	// }
	
}
