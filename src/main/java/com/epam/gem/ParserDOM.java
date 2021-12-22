package com.epam.gem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserDOM {

    public List<Gem> parse(String path) throws GemException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File file = new File(path);

        DocumentBuilder builder;
        Document document;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(file);
        }
        catch (ParserConfigurationException | SAXException | IOException e){
            throw new GemException(e.getMessage(), e);
        }

        List<Gem> gems = new ArrayList<>();

        NodeList gemNodeList = document.getElementsByTagName("gem");
        for (int i = 0; i < gemNodeList.getLength(); i++) {
            Node node = gemNodeList.item(i);
            Element element = (Element) node;

            Gem gem = new Gem();
            setGemFields(gem, element);
            gems.add(gem);
        }

        NodeList diamondNodeList = document.getElementsByTagName("diamond");
        for (int i = 0; i < diamondNodeList.getLength(); i++) {
            Node node = diamondNodeList.item(i);
            Element element = (Element) node;

            Diamond diamond = new Diamond();
            setGemFields(diamond, element);

            String crystalShapeString = getValue(element, "crystal_shape");
            CrystalShape crystalShape = CrystalShape.valueOf(crystalShapeString);
            diamond.setCrystalShape(crystalShape);

            gems.add(diamond);
        }

        NodeList sapphireNodeList = document.getElementsByTagName("sapphire");
        for (int i = 0; i < sapphireNodeList.getLength(); i++) {
            Node node = sapphireNodeList.item(i);
            Element element = (Element) node;

            Sapphire sapphire = new Sapphire();
            setGemFields(sapphire, element);

            String color = getValue(element, "color");
            sapphire.setColor(color);

            gems.add(sapphire);
        }

        return gems;
    }

    public String getValue(Element element, String tagName) {
        NodeList list = element.getElementsByTagName(tagName);
        Node firstNode = list.item(0);
        return firstNode.getTextContent();
    }

    public void setGemFields(Gem gem, Element element){
        String idString = element.getAttribute("id");
        int id = Integer.parseInt(idString);
        gem.setId(id);

        String name = getValue(element, "name");
        gem.setName(name);

        String preciousnessString = getValue(element, "preciousness");
        Preciousness preciousness = Preciousness.valueOf(preciousnessString);
        gem.setPreciousness(preciousness);

        String origin = getValue(element, "origin");
        gem.setOrigin(origin);

        String transparencyString = getValue(element, "transparency");
        double transparency = Double.parseDouble(transparencyString);
        gem.setTransparency(transparency);

        String valueString = getValue(element, "value");
        double value = Double.parseDouble(valueString);
        gem.setValue(value);
    }
}
