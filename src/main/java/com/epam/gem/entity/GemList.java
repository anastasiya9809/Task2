package com.epam.gem.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "gems")
public class GemList {
    @XmlElements({
            @XmlElement(name = "gem"),
            @XmlElement(name = "diamond", type = Diamond.class),
            @XmlElement(name = "sapphire", type = Sapphire.class)
    })
    private List<Gem> gems = new ArrayList<>();

    public List<Gem> getGems() {
        return gems;
    }
}
