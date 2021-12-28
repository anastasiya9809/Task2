package com.epam.gem.logic;

import com.epam.gem.entity.Gem;
import com.epam.gem.entity.Gems;
import com.epam.gem.exception.GemException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import java.util.List;

public class GemJaxbParser implements Parser{

    @Override
    public List<Gem> parse(String path) throws GemException {
        try {
            JAXBContext context = JAXBContext.newInstance(Gems.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(path);
            Gems gems = (Gems) unmarshaller.unmarshal(file);
            return gems.getList();
        }
        catch (JAXBException exception) {
            throw new GemException(exception.getMessage(), exception);
        }
    }
}
