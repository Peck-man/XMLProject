package com.example.xmlproject.services;

import com.example.xmlproject.models.Village;
import com.example.xmlproject.repositories.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Service
public class VillageService {
    @Autowired
    VillageRepository villageRepository;

    public void saveVillage() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("20210331_OB_573060_UZSZ.xml");
        NodeList nodeList = doc.getElementsByTagName("vf:Obec");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element eElement = (Element) node;
            String nameOfTheVillage = eElement.getElementsByTagName("obi:Nazev").item(0).getTextContent();
            int code = Integer.parseInt(eElement.getElementsByTagName("obi:Kod").item(0).getTextContent());
            Village villageToSave = new Village(nameOfTheVillage, code);
            villageRepository.save(villageToSave);
        }
    }
}
