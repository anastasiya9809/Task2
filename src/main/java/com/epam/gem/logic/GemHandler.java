package com.epam.gem.logic;

import com.epam.gem.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class GemHandler extends DefaultHandler {

    private List<Gem> gems;
    private StringBuilder currentField;
    private int id;
    private String color;
    private String name;
    private Preciousness preciousness;
    private String origin;
    private double transparency;
    private double value;
    private CrystalShape crystalShape;
    private double refractiveIndex;
    private static final String DIAMOND = "diamond";
    private static final String SAPPHIRE = "sapphire";
    private static final String NAME = "name";
    private static final String PRECIOUSNESS = "preciousness";
    private static final String ORIGIN = "origin";
    private static final String TRANSPARENCY = "transparency";
    private static final String VALUE = "value";
    private static final String CRYSTAL_SHAPE = "crystal_shape";
    private static final String REFRACTIVE_INDEX = "refractive_index";

    @Override
    public void startDocument() {
        gems = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        if (DIAMOND.equals(qualifiedName) || SAPPHIRE.equals(qualifiedName)) {
                setAttributes(attributes);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        switch(qualifiedName) {
            case DIAMOND:
                gems.add(new Diamond(id, color, name, preciousness, origin, transparency, value, crystalShape));
                break;
            case SAPPHIRE:
                gems.add(new Sapphire(id, color, name, preciousness, origin, transparency, value, refractiveIndex));
                break;
            case NAME:
                name = currentField.toString();
                break;
            case PRECIOUSNESS:
                String preciousnessString = currentField.toString();
                preciousness = Preciousness.valueOf(preciousnessString);
                break;
            case ORIGIN:
                origin = currentField.toString();
                break;
            case TRANSPARENCY:
                String transparencyString = currentField.toString();
                transparency = Double.parseDouble(transparencyString);
                break;
            case VALUE:
                String valueString = currentField.toString();
                value = Double.parseDouble(valueString);
                break;
            case CRYSTAL_SHAPE:
                String crystalShapeString = currentField.toString();
                crystalShape = CrystalShape.valueOf(crystalShapeString);
                break;
            case REFRACTIVE_INDEX:
                String refractiveIndexString = currentField.toString();
                refractiveIndex = Double.parseDouble(refractiveIndexString);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentField = new StringBuilder();
        currentField.append(ch, start, length);
    }

    public void setAttributes(Attributes attributes){
        String idString = attributes.getValue(0);
        id = Integer.parseInt(idString);

        color = attributes.getValue(1);
        if (color == null) {
            color = "color not specified";
        }
    }

    public List<Gem> getGems() {
        return gems;
    }
}
