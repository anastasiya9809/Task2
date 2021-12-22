package com.epam.gem;

import java.util.Objects;

public class Gem {
    private int id;
    private String name;
    private Preciousness preciousness;
    private String origin;
    private double transparency;
    private double value;

    public Gem() {}

    public Gem(int id, String name, Preciousness preciousness, String origin,
               double transparency, double value) {
        this.id = id;
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.transparency = transparency;
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gem gem = (Gem) o;
        return id == gem.id
                && Double.compare(gem.transparency, transparency) == 0
                && Double.compare(gem.value, value) == 0
                && name.equals(gem.name)
                && preciousness == gem.preciousness
                && origin.equals(gem.origin);
    }
}
