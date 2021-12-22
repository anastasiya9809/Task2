package com.epam.gem;

import java.util.Objects;

public class Diamond extends Gem {

    private CrystalShape crystalShape;

    public Diamond() {}

    public Diamond(int id, String name, Preciousness preciousness, String origin,
                    double transparency, double value, CrystalShape crystalShape) {
        super(id, name, preciousness, origin, transparency, value);
        this.crystalShape = crystalShape;
    }

    public void setCrystalShape(CrystalShape crystalShape) {
        this.crystalShape = crystalShape;
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
        Diamond diamond = (Diamond) o;
        return crystalShape == diamond.crystalShape;
    }
}
