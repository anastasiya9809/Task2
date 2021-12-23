package com.epam.gem.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sapphire")
public class Sapphire extends Gem {

    @XmlElement
    private String color;

    public Sapphire() {}

    public Sapphire(int id, String name, Preciousness preciousness, String origin,
                    double transparency, double value, String color) {
        super(id, name, preciousness, origin, transparency, value);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Sapphire sapphire = (Sapphire) o;
        return color.equals(sapphire.color);
    }
}
