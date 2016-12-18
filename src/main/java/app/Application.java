package app;

import app.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

/**
 * Ta aplikacja startuje i wystawia kontroler rest do rozmowy z systemem.
 * Jednocześnie system ma dostęp do bazy danych.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Filter corsConfigurer() {
        return new CorsFilter();
    }
}
