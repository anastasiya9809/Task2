package com.epam.gem;

import com.epam.gem.exception.GemException;
import com.epam.gem.logic.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {
    private static final String PATH_TO_VALID_XML = "src/test/resources/xml";
    private static final String PATH_TO_INVALID_XML = "src/test/resources/xml2";
    private static final String XSD_PATH = "src/test/resources/xsd";
    private static final String INVALID_PATH = "";

    @Test
    public void testValidateShouldReturnTrueWhenXMLValidAgainstXSD() throws GemException {
        //given
        XmlValidator validator = new XmlValidator();

        //when
        boolean result = validator.isValid(PATH_TO_VALID_XML, XSD_PATH);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testValidateShouldReturnFalseWhenXMLInvalidAgainstXSD() throws GemException {
        //given
        XmlValidator validator = new XmlValidator();

        //when
        boolean result = validator.isValid(PATH_TO_INVALID_XML, XSD_PATH);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testValidateShouldReturnFalseWhenXMLPathInvalid() throws GemException {
        //given
        XmlValidator validator = new XmlValidator();

        //when
        boolean result = validator.isValid(INVALID_PATH, XSD_PATH);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testValidateShouldReturnFalseWhenXSDPathInvalid() throws GemException {
        //given
        XmlValidator validator = new XmlValidator();

        //when
        boolean result = validator.isValid(PATH_TO_VALID_XML, INVALID_PATH);

        //then
        Assert.assertFalse(result);
    }
}
