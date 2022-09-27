package com.example.xmlproject;

import com.example.xmlproject.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@SpringBootApplication
public class XmlProjectApplication implements CommandLineRunner {
    @Autowired
    MainService mainService;
    // TODO need to do automatic downloading and refactoring

    public static void main(String[] args) {
        SpringApplication.run(XmlProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mainService.runService();
    }
    }

