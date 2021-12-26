package com.epam.gem.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "gems")
@XmlAccessorType(XmlAccessType.FIELD)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GemList gemList = (GemList) o;
        return gems.equals(gemList.gems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gems);
    }
}
