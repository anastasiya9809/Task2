package com.epam.gem;

import com.epam.gem.entity.*;
import com.epam.gem.exception.GemException;
import com.epam.gem.logic.ParserSAX;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParserSAXTest {
    private static final String VALID_PATH = "C:\\Users\\aausi\\Documents\\Task2\\src\\test\\resources\\xml";
    private static final String INVALID_PATH = "";
    private static final List<Gem> GEMS = Arrays.asList(
            new Gem(1, "star ruby", Preciousness.PRECIOUS, "Myanmar",
                    5, 1),
            new Gem(2, "Colombian emerald", Preciousness.SEMIPRECIOUS, "Colombia",
                    20, 2),
            new Diamond(3, "white diamond", Preciousness.PRECIOUS, "Botswana",
                    50, 0.5, CrystalShape.OCTAHEDRAL),
            new Diamond(4, "blue diamond", Preciousness.PRECIOUS, "South Africa",
                    90, 0.75, CrystalShape.CUBIC),
            new Sapphire(5, "blue sapphire", Preciousness.SEMIPRECIOUS, "Australia",
                    75, 1.5, "blue"),
            new Sapphire(6, "pink sapphire", Preciousness.SEMIPRECIOUS, "Thailand",
                    80, 1.25, "pink"));

    @Test
    public void testParseShouldParseWhenPathValid() throws GemException {
        //given
        ParserSAX parser = new ParserSAX();

        //when
        List<Gem> result = parser.parse(VALID_PATH);

        //then
        Assert.assertEquals(GEMS, result);
    }

    @Test(expected = GemException.class)
    public void testParseShouldThrowExceptionWhenPathInvalid() throws GemException {
        //given
        ParserSAX parser = new ParserSAX();

        //when
        parser.parse(INVALID_PATH);
    }
}
