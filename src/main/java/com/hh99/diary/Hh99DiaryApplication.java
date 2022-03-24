package com.hh99.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hh99DiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hh99DiaryApplication.class, args);
    }

}