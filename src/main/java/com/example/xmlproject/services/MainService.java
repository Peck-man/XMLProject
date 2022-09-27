package com.example.xmlproject.services;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Service
public class MainService {

    VillageService villageService;
    VillagePartService villagePartService;

    public MainService(VillageService villageService, VillagePartService villagePartService) {
        this.villageService = villageService;
        this.villagePartService = villagePartService;
    }

    public void runService() throws ParserConfigurationException, IOException, SAXException {
        villageService.saveVillage();
        villagePartService.saveVillage();
    }
}
