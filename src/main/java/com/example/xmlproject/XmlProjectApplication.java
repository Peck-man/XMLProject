package com.example.xmlproject;

import com.example.xmlproject.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlProjectApplication implements CommandLineRunner {
    @Autowired
    MainService mainService;

    public static void main(String[] args) {
        SpringApplication.run(XmlProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainService.run();
    }
    }

