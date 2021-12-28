package com.epam.gem.logic;

import com.epam.gem.exception.GemException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public boolean isValid(String xmlPath, String xsdPath) throws GemException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsdFile = new File(xsdPath);
        Schema schema;

        try {
            schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            File xmlFile = new File(xmlPath);
            StreamSource source = new StreamSource(xmlFile);
            validator.validate(source);
            return true;
        }
        catch (SAXException e) {
            return false;
        }
        catch (IOException e) {
            throw new GemException(e.getMessage(), e);
        }
    }
}
