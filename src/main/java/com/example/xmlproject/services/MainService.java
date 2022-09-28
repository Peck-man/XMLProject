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
    String fileName = "KopidlnoVillage";
    String url = "https://www.smartform.cz/download/kopidlno.xml.zip";


    public MainService(VillageService villageService, VillagePartService villagePartService) {
        this.villageService = villageService;
        this.villagePartService = villagePartService;
    }

    public void run() throws ParserConfigurationException, IOException, SAXException, ZipException {
        fileName = downloadFile();
        villageService.saveVillage(fileName);
        villagePartService.saveVillage(fileName);
    }

    public String downloadFile() throws IOException, ZipException {
        BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".zip");
        byte[] dataBuffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }
        unzipAndCreateFile();
        return "src/main/resources/20210331_OB_573060_UZSZ.xml";
    }

    public void unzipAndCreateFile() throws ZipException {
        ZipFile zipFile = new ZipFile(fileName + ".zip");
        zipFile.extractAll("src/main/resources");
    }
}
