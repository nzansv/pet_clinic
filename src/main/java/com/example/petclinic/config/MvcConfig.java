package com.example.petclinic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/reg").setViewName("reg");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/add-petowner").setViewName("add-petowner");
        registry.addViewController("/list-petowners").setViewName("list-petowners");
        registry.addViewController("/list-veterinarians").setViewName("list-veterinarians");

    }



}
