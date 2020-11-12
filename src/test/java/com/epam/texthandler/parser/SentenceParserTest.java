package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class SentenceParserTest {

    private static final String TEST_SOURCE = "Word word word";

    private final Leaf word = Leaf.wordFrom("word");
    private final Component expected = new Composite(
            Arrays.asList(
                    word, word, word
            )
    );

    @Test
    public void testParseShouldReturnCorrectComposite() throws ParseException {
        //given
        Parser successor = Mockito.mock(Parser.class);
        Parser parser = new SentenceParser(successor);
        // when
        when(successor.parse(anyString())).thenReturn(word);
        Component actual = parser.parse(TEST_SOURCE);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParseException.class)
    public void testParseShouldThrowParseExceptionWhenSuccessorIsNull() throws ParseException {
        //given
        Parser parser = new SentenceParser(null);
        // when
        Component actual = parser.parse(TEST_SOURCE);
        //then
    }
}
