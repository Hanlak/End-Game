package com.endgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.endgame"})
public class TheEndGameApp {

    public static void main(String[] args) {
        SpringApplication.run(TheEndGameApp.class, args);
    }
}
