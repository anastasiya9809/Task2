package com.epam.gem;

import com.epam.gem.entity.*;
import com.epam.gem.exception.GemException;
import com.epam.gem.logic.GemDomParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GemDomParserTest {
    private static final String VALID_PATH = "src/test/resources/xml";
    private static final String INVALID_PATH = "";
    private static final List<Gem> GEMS = Arrays.asList(
            new Diamond(3, "color not specified", "white diamond", Preciousness.PRECIOUS, "Botswana",
                    50, 0.5, CrystalShape.OCTAHEDRAL),
            new Diamond(4, "blue", "blue diamond", Preciousness.PRECIOUS, "South Africa",
                    90, 0.75, CrystalShape.CUBIC),
            new Sapphire(5, "blue", "blue sapphire", Preciousness.SEMIPRECIOUS, "Australia",
                    75, 1.5, 1.765),
            new Sapphire(6, "pink", "pink sapphire", Preciousness.SEMIPRECIOUS, "Thailand",
                    80, 1.25, 1.766));

    @Test
    public void testParseShouldParseFileWhenPathValid() throws GemException {
        //given
        GemDomParser parser = new GemDomParser();

        //when
        List<Gem> result = parser.parse(VALID_PATH);

        //then
        Assert.assertEquals(GEMS, result);
    }

    @Test(expected = GemException.class)
    public void testParseShouldThrowExceptionWhenPathInvalid() throws GemException {
        //given
        GemDomParser parser = new GemDomParser();

        //when
        parser.parse(INVALID_PATH);
    }
}
