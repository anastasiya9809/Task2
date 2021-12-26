package com.epam.gem.logic;

import com.epam.gem.entity.Gem;
import com.epam.gem.entity.GemList;
import com.epam.gem.exception.GemException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class ParserJAXB {

    public List<Gem> parse(String path) throws GemException {

        File file = new File(path);
        JAXBContext context;
        Unmarshaller unmarshaller;
        GemList gemList;

        try {
            context = JAXBContext.newInstance(GemList.class);
            unmarshaller = context.createUnmarshaller();
            gemList = (GemList) unmarshaller.unmarshal(file);
        }
        catch (JAXBException e) {
            throw new GemException(e.getMessage(), e);
        }

        for (Gem gem : gemList.getGems()) {
           if (gem.getColor() == null) {
               gem.setColor("color not specified");
           }
        }

        return gemList.getGems();
    }
}
