package com.example.xmlproject.services;

import com.example.xmlproject.models.Village;
import com.example.xmlproject.models.VillagePart;
import com.example.xmlproject.repositories.VillagePartRepository;
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
public class VillagePartService {
    @Autowired
    VillagePartRepository villagePartRepository;
    public void saveVillage(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        NodeList nodeList = doc.getElementsByTagName("vf:CastObce");
        NodeList nodeList1 = doc.getElementsByTagName("coi:Obec");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element eElement = (Element) node;
            Node node1 = nodeList1.item(i);
            Element element = (Element) node1;
            int code = Integer.parseInt(eElement.getElementsByTagName("coi:Kod").item(0).getTextContent());
            String nameOfTheVillage = eElement.getElementsByTagName("coi:Nazev").item(0).getTextContent();
            int villageCode = Integer.parseInt(element.getElementsByTagName("obi:Kod").item(0).getTextContent());
            VillagePart villagePartToSave = new VillagePart(code, villageCode, nameOfTheVillage);
            villagePartRepository.save(villagePartToSave);
        }
    }
}
