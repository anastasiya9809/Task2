package com.epam.gem.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Gem {
    @XmlAttribute
    private int id;
    @XmlAttribute
    private String color;
    @XmlElement
    private String name;
    @XmlElement
    private Preciousness preciousness;
    @XmlElement
    private String origin;
    @XmlElement
    private double transparency;
    @XmlElement
    private double value;

    //default constructor required for parse method in GemJaxbParser class
    public Gem() {}

    public Gem(int id, String color, String name, Preciousness preciousness, String origin,
               double transparency, double value) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.transparency = transparency;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    //setter method required for getList() method in Gems class, to set default color value, if needed
    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public double getTransparency() {
        return transparency;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Gem gem = (Gem) object;
        return id == gem.id
                && Double.compare(gem.transparency, transparency) == 0
                && Double.compare(gem.value, value) == 0
                && color.equals(gem.color)
                && name.equals(gem.name)
                && preciousness == gem.preciousness
                && origin.equals(gem.origin);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + color.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + preciousness.hashCode();
        result = 31 * result + origin.hashCode();
        result = 31 * result + Double.hashCode(transparency);
        result = 31 * result + Double.hashCode(value);
        return result;
    }
}
