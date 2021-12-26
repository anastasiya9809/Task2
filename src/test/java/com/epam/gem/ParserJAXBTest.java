package com.epam.gem;

import com.epam.gem.entity.*;
import com.epam.gem.exception.GemException;
import com.epam.gem.logic.ParserJAXB;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParserJAXBTest {
    private static final String VALID_PATH = "C:\\Users\\aausi\\Documents\\Task2\\src\\test\\resources\\xml";
    private static final String INVALID_PATH = "";
    private static final List<Gem> GEMS = Arrays.asList(
            new Gem(1, "color not specified", "star ruby", Preciousness.PRECIOUS, "Myanmar",
                    5, 1),
            new Gem(2, "green", "Colombian emerald", Preciousness.SEMIPRECIOUS, "Colombia",
                    20, 2),
            new Diamond(3, "white", "white diamond", Preciousness.PRECIOUS, "Botswana",
                    50, 0.5, CrystalShape.OCTAHEDRAL),
            new Diamond(4, "blue", "blue diamond", Preciousness.PRECIOUS, "South Africa",
                    90, 0.75, CrystalShape.CUBIC),
            new Sapphire(5, "blue", "blue sapphire", Preciousness.SEMIPRECIOUS, "Australia",
                    75, 1.5, 1.765),
            new Sapphire(6, "pink", "pink sapphire", Preciousness.SEMIPRECIOUS, "Thailand",
                    80, 1.25, 1.766));

    @Test
    public void testParseShouldParseWhenPathValid() throws GemException {
        //given
        ParserJAXB parser = new ParserJAXB();

        //when
        List<Gem> result = parser.parse(VALID_PATH);

        //then
        Assert.assertEquals(GEMS, result);
    }

    @Test(expected = GemException.class)
    public void testParseShouldThrowExceptionWhenPathInvalid() throws GemException {
        //given
        ParserJAXB parser = new ParserJAXB();

        //when
        parser.parse(INVALID_PATH);
    }
}
