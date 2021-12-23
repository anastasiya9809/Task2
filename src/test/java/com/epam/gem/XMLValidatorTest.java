package com.epam.gem;

import com.epam.gem.exception.GemException;
import com.epam.gem.logic.XMLValidator;
import org.junit.Assert;
import org.junit.Test;

public class XMLValidatorTest {
    private static final String PATH_TO_VALID_XML = "C:\\Users\\aausi\\Documents\\Task2\\src\\test\\resources\\xml";
    private static final String PATH_TO_INVALID_XML = "C:\\Users\\aausi\\Documents\\Task2\\src\\test\\resources\\xml2";
    private static final String XSD_PATH = "C:\\Users\\aausi\\Documents\\Task2\\src\\test\\resources\\xsd";
    private static final String INVALID_PATH = "";

    @Test
    public void testValidateShouldReturnTrueWhenXMLValidAgainstXSD() throws GemException {
        //given
        XMLValidator validator = new XMLValidator();

        //when
        boolean result = validator.isValid(PATH_TO_VALID_XML, XSD_PATH);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testValidateShouldReturnFalseWhenXMLInvalidAgainstXSD() throws GemException {
        //given
        XMLValidator validator = new XMLValidator();

        //when
        boolean result = validator.isValid(PATH_TO_INVALID_XML, XSD_PATH);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testValidateShouldReturnFalseWhenXMLPathInvalid() throws GemException {
        //given
        XMLValidator validator = new XMLValidator();

        //when
        boolean result = validator.isValid(INVALID_PATH, XSD_PATH);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testValidateShouldReturnFalseWhenXSDPathInvalid() throws GemException {
        //given
        XMLValidator validator = new XMLValidator();

        //when
        boolean result = validator.isValid(PATH_TO_VALID_XML, INVALID_PATH);

        //then
        Assert.assertFalse(result);
    }
}
