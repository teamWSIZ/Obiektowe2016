package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ta aplikacja startuje i wystawia kontroler rest do rozmowy z systemem.
 * Jednocześnie system ma dostęp do bazy danych.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
