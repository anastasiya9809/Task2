package com.epam.gem.entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Sapphire extends Gem {

    @XmlElement(name = "refractive_index")
    private double refractiveIndex;

    public Sapphire() {}

    public Sapphire(int id, String color, String name, Preciousness preciousness, String origin,
                    double transparency, double value, double refractiveIndex) {
        super(id, color, name, preciousness, origin, transparency, value);
        this.refractiveIndex = refractiveIndex;
    }

    public void setRefractiveIndex(double refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sapphire sapphire = (Sapphire) o;
        return refractiveIndex == sapphire.refractiveIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refractiveIndex);
    }
}
