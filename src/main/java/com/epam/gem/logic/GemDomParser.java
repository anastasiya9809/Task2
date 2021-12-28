package com.epam.gem.logic;

import com.epam.gem.exception.GemException;
import com.epam.gem.entity.*;
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

public class GemDomParser implements Parser {

    private static final String DIAMOND = "diamond";
    private static final String SAPPHIRE = "sapphire";
    private static final String ID = "id";
    private static final String COLOR = "color";
    private static final String NAME = "name";
    private static final String PRECIOUSNESS = "preciousness";
    private static final String ORIGIN = "origin";
    private static final String TRANSPARENCY = "transparency";
    private static final String VALUE = "value";
    private static final String CRYSTAL_SHAPE = "crystal-shape";
    private static final String REFRACTIVE_INDEX = "refractive-index";

    @Override
    public List<Gem> parse(String path) throws GemException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File file = new File(path);
        Document document;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(file);
        }
        catch (ParserConfigurationException | SAXException | IOException exception){
            throw new GemException(exception.getMessage(), exception);
        }

        List<Gem> gems = new ArrayList<>();

        NodeList diamondNodeList = document.getElementsByTagName(DIAMOND);
        for (int i = 0; i < diamondNodeList.getLength(); i++) {
            Node node = diamondNodeList.item(i);
            Element element = (Element) node;
            Gem gem = createGem(element);
            Diamond diamond = createDiamond(element, gem);
            gems.add(diamond);
        }

        NodeList sapphireNodeList = document.getElementsByTagName(SAPPHIRE);
        for (int i = 0; i < sapphireNodeList.getLength(); i++) {
            Node node = sapphireNodeList.item(i);
            Element element = (Element) node;
            Gem gem = createGem(element);
            Sapphire sapphire = createSapphire(element, gem);
            gems.add(sapphire);
        }

        return gems;
    }

    public String getValue(Element element, String tagName) {
        NodeList list = element.getElementsByTagName(tagName);
        Node firstNode = list.item(0);
        return firstNode.getTextContent();
    }

    public Gem createGem(Element element) {
        String idString = element.getAttribute(ID);
        int id = Integer.parseInt(idString);

        String color = element.getAttribute(COLOR);
        if (color.isEmpty()) {
            color = "color not specified";
        }

        String name = getValue(element, NAME);

        String preciousnessString = getValue(element, PRECIOUSNESS);
        Preciousness preciousness = Preciousness.valueOf(preciousnessString);

        String origin = getValue(element, ORIGIN);

        String transparencyString = getValue(element, TRANSPARENCY);
        double transparency = Double.parseDouble(transparencyString);

        String valueString = getValue(element, VALUE);
        double value = Double.parseDouble(valueString);
        
        return new Gem(id, color, name, preciousness, origin,
                transparency, value);
    }
    
    public Diamond createDiamond(Element element, Gem gem) {
        String crystalShapeString = getValue(element, CRYSTAL_SHAPE);
        CrystalShape crystalShape = CrystalShape.valueOf(crystalShapeString);
        return new Diamond(gem.getId(), gem.getColor(), gem.getName(), gem.getPreciousness(),
                gem.getOrigin(), gem.getTransparency(), gem.getValue(), crystalShape);
    }

    public Sapphire createSapphire(Element element, Gem gem) {
        String refractiveIndexString = getValue(element, REFRACTIVE_INDEX);
        double refractiveIndex = Double.parseDouble(refractiveIndexString);
        return new Sapphire(gem.getId(), gem.getColor(), gem.getName(), gem.getPreciousness(),
                gem.getOrigin(), gem.getTransparency(), gem.getValue(), refractiveIndex);
    }
}
