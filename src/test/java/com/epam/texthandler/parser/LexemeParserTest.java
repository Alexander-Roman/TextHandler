package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Leaf;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LexemeParserTest {

    private final Parser parser = new LexemeParser(null);

    @Test
    public void testParseShouldReturnLeafOfMathTypeWhenStringIsMathExpression() throws ParseException {
        //given
        String given = "13_9_+_2_*";
        //when
        Component actual = parser.parse(given);
        //then
        Leaf expected = Leaf.mathFrom("13_9_+_2_*");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParseShouldReturnLeafOfWordTypeWhenStringIsNotMathExpression() throws ParseException {
        //given
        String given = "Word";
        //when
        Component actual = parser.parse(given);
        //then
        Leaf expected = Leaf.wordFrom("Word");
        Assert.assertEquals(actual, expected);
    }

}
