package com.example.xmlproject.services;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Service
public class MainService {

    VillageService villageService;

    public MainService(VillageService villageService) {
        this.villageService = villageService;
    }

    public void runService() throws ParserConfigurationException, IOException, SAXException {
        villageService.saveVillage();
    }
}
