package com.example.xmlproject;

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

    public static void main(String[] args) {
        SpringApplication.run(XmlProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("20210331_OB_573060_UZSZ.xml");
        NodeList nodeList = doc.getElementsByTagName("vf:Obec");
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("\nNode Name :" + node.getNodeName());
            Element eElement = (Element) node;
            System.out.println("Název obce " + eElement.getElementsByTagName("obi:Nazev").item(0).getTextContent());

        }
    }
    }

