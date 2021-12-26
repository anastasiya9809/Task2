package com.epam.gem.logic;

import com.epam.gem.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class GemHandler extends DefaultHandler {

    private List<Gem> gems;
    private StringBuilder currentField;

    @Override
    public void startDocument() {
        gems = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch(qName) {
            case "gem":
                addGemToList(new Gem(), attributes);
                break;
            case "diamond":
                addGemToList(new Diamond(), attributes);
                break;
            case "sapphire":
                addGemToList(new Sapphire(), attributes);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        Gem gem;

        switch(qName) {
            case "name":
                gem = getCurrentGem();
                String name = currentField.toString();
                gem.setName(name);
                break;
            case "preciousness":
                gem = getCurrentGem();
                String preciousnessString = currentField.toString();
                Preciousness preciousness = Preciousness.valueOf(preciousnessString);
                gem.setPreciousness(preciousness);
                break;
            case "origin":
                gem = getCurrentGem();
                String origin = currentField.toString();
                gem.setOrigin(origin);
                break;
            case "transparency":
                gem = getCurrentGem();
                String transparencyString = currentField.toString();
                double transparency = Double.parseDouble(transparencyString);
                gem.setTransparency(transparency);
                break;
            case "value":
                gem = getCurrentGem();
                String valueString = currentField.toString();
                double value = Double.parseDouble(valueString);
                gem.setValue(value);
                break;
            case "crystal_shape":
                Diamond diamond = getCurrentDiamond();
                String crystalShapeString = currentField.toString();
                CrystalShape crystalShape = CrystalShape.valueOf(crystalShapeString);
                diamond.setCrystalShape(crystalShape);
                break;
            case "refractive_index":
                Sapphire sapphire = getCurrentSapphire();
                String refractiveIndexString = currentField.toString();
                double refractiveIndex = Double.parseDouble(refractiveIndexString);
                sapphire.setRefractiveIndex(refractiveIndex);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentField = new StringBuilder();
        currentField.append(ch, start, length);
    }

    public Gem getCurrentGem() {
        int lastIndex = gems.size() - 1;
        return gems.get(lastIndex);
    }

    public Diamond getCurrentDiamond() {
        int lastIndex = gems.size() - 1;
        return (Diamond)gems.get(lastIndex);
    }

    public Sapphire getCurrentSapphire() {
        int lastIndex = gems.size() - 1;
        return (Sapphire)gems.get(lastIndex);
    }

    public void addGemToList(Gem gem, Attributes attributes){
        String idString = attributes.getValue(0);
        int id = Integer.parseInt(idString);
        gem.setId(id);

        String color = attributes.getValue(1);
        if (color != null) {
            gem.setColor(color);
        } else {
            String defaultColor = "color not specified";
            gem.setColor(defaultColor);
        }

        gems.add(gem);
    }

    public List<Gem> getGems() {
        return gems;
    }
}
