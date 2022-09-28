package com.example.xmlproject.services;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Service
public class MainService {

    VillageService villageService;
    VillagePartService villagePartService;

    public MainService(VillageService villageService, VillagePartService villagePartService) {
        this.villageService = villageService;
        this.villagePartService = villagePartService;
    }

    public void runService() throws ParserConfigurationException, IOException, SAXException, ZipException {
        String fileName = downAndCreateFile();
        villageService.saveVillage(fileName);
        villagePartService.saveVillage(fileName);
    }

    public String downAndCreateFile() throws IOException, ZipException {
        String fileName = "20210331_OB_573060_UZSZ.zip";
        String url = "https://www.smartform.cz/download/kopidlno.xml.zip";
        BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }
        ZipFile zipFile = new ZipFile("20210331_OB_573060_UZSZ.zip");
        zipFile.extractAll("src/main/resources");

        return "src/main/resources/20210331_OB_573060_UZSZ.xml";
    }
}
