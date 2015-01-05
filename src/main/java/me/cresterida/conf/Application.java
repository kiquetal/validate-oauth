package me.cresterida.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "me.cresterida.conf")
@EnableAutoConfiguration
@Configuration

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
