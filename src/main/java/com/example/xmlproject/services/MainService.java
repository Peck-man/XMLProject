package com.example.xmlproject.services;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Service
public class MainService {

    VillageService villageService;
    VillagePartService villagePartService;

    public MainService(VillageService villageService, VillagePartService villagePartService) {
        this.villageService = villageService;
        this.villagePartService = villagePartService;
    }

    public void runService() throws ParserConfigurationException, IOException, SAXException {
        String fileName = downAndCreateFile();
        villageService.saveVillage(fileName);
        villagePartService.saveVillage(fileName);
    }

    public String downAndCreateFile() throws IOException {
        String fileName = "sourceFile.xml";
        URL url = new URL("https://www.smartform.cz/download/kopidlno.xml.zip");
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        return fileName;
    }
}
