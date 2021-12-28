package com.epam.gem.logic;

import com.epam.gem.entity.ParserType;

public class ParserFactory {
    public Parser create(ParserType type) {
        switch (type) {
            case DOM:
                return new GemDomParser();
            case JAXB:
                return new GemJaxbParser();
            case SAX:
                return new GemSaxParser();
            default:
                throw new IllegalArgumentException("invalid parser type");
        }
    }
}
