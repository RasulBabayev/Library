package com.company.LibraryApplicationWithSpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibraryApplicationWithSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplicationWithSpringMvcApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
    @Bean
    public static WebSecurityConfiguration webSecurityConfiguration() {
        return new WebSecurityConfiguration();
    }


}
