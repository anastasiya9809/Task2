package com.epam.gem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParserSAXTest {
    private static final String VALID_PATH = "C:\\Users\\aausi\\Documents\\Task2\\src\\test\\resources\\xml";
    private static final String INVALID_PATH = "";

    @Test
    public void testParseShouldParseWhenPathValid() throws GemException {
        //given
        ParserSAX parser = new ParserSAX();

        //when
        List<Gem> actual = parser.parse(VALID_PATH);
        List<Gem> expected = Arrays.asList(
                new Gem(1, "star_ruby", Preciousness.PRECIOUS, "Myanmar",
                        5, 1),
                new Gem(2, "colombian_emerald", Preciousness.SEMIPRECIOUS, "Colombia",
                        20, 2),
                new Diamond(3, "white_diamond", Preciousness.PRECIOUS, "Botswana",
                        50, 0.5, CrystalShape.OCTAHEDRAL),
                new Sapphire(4, "blue_sapphire", Preciousness.SEMIPRECIOUS, "Australia",
                        75, 1.5, "blue"));

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = GemException.class)
    public void testParseShouldThrowExceptionWhenPathInvalid() throws GemException {
        //given
        ParserSAX parser = new ParserSAX();

        //when
        parser.parse(INVALID_PATH);
    }
}
