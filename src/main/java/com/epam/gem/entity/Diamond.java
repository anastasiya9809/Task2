package com.epam.gem.entity;

import javax.xml.bind.annotation.XmlElement;

public class Diamond extends Gem {

    @XmlElement(name = "crystal_shape")
    private CrystalShape crystalShape;

    //default constructor required for parse method in GemJaxbParser class
    public Diamond() {}

    public Diamond(int id, String color, String name, Preciousness preciousness, String origin,
                   double transparency, double value, CrystalShape crystalShape) {
        super(id, color, name, preciousness, origin, transparency, value);
        this.crystalShape = crystalShape;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Diamond diamond = (Diamond) object;
        return crystalShape == diamond.crystalShape;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + crystalShape.hashCode();
        return result;
    }
}
