package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {

    private static final String TEST_SOURCE = "Test sentence. Test sentence. Test sentence.";

    private final Component sentence = new Composite(
            Arrays.asList(
                    Leaf.wordFrom("Test"),
                    Leaf.wordFrom("sentence.")
            )
    );
    private final Component expected = new Composite(
            Arrays.asList(
                    sentence, sentence, sentence
            )
    );

    @Test
    public void testParseShouldReturnCorrectComposite() throws ParseException {
        //given
        Parser successor = Mockito.mock(Parser.class);
        Parser parser = new ParagraphParser(successor);
        // when
        when(successor.parse(anyString())).thenReturn(sentence);
        Component actual = parser.parse(TEST_SOURCE);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParseException.class)
    public void testParseShouldThrowParseExceptionWhenSuccessorIsNull() throws ParseException {
        //given
        Parser parser = new ParagraphParser(null);
        // when
        Component actual = parser.parse(TEST_SOURCE);
        //then
    }
}
