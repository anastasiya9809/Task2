package com.epam.gem.entity;

import javax.xml.bind.annotation.XmlElement;

public class Sapphire extends Gem {

    @XmlElement(name = "refractive_index")
    private double refractiveIndex;

    //default constructor required for parse method in GemJaxbParser class
    public Sapphire() {}

    public Sapphire(int id, String color, String name, Preciousness preciousness, String origin,
                    double transparency, double value, double refractiveIndex) {
        super(id, color, name, preciousness, origin, transparency, value);
        this.refractiveIndex = refractiveIndex;
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
        Sapphire sapphire = (Sapphire) object;
        return refractiveIndex == sapphire.refractiveIndex;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(refractiveIndex);
        return result;
    }
}
