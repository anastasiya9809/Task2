package com.epam.gem.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Gems {
    @XmlElements({
            @XmlElement(name = "diamond", type = Diamond.class),
            @XmlElement(name = "sapphire", type = Sapphire.class)
    })
    private final List<Gem> list = new ArrayList<>();

    public List<Gem> getList() {
        for (Gem gem : list) {
             if (gem.getColor() == null) {
                gem.setColor("color not specified");
             }
         }
         return list;
    }
}
