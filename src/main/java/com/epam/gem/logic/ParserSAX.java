package com.epam.gem.logic;

import com.epam.gem.exception.GemException;
import com.epam.gem.entity.Gem;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class ParserSAX {

    public List<Gem> parse(String path) throws GemException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        GemHandler handler = new GemHandler();

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(path, handler);
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            throw new GemException(e.getMessage(), e);
        }

        return handler.getGems();
    }
}
