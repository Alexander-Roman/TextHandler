package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TextParserTest {

    private static final String TEST_SOURCE = "Paragraph\nParagraph\r\nParagraph";

    private final Component sentence = new Composite(
            Collections.singletonList(
                    Leaf.wordFrom("Paragraph")
            )
    );
    private final Component paragraph = new Composite(
            Collections.singletonList(
                    sentence
            )
    );
    private final Component expected = new Composite(
            Arrays.asList(
                    paragraph, paragraph, paragraph
            )
    );

    @Test
    public void testParseShouldReturnCorrectComposite() throws ParseException {
        //given
        Parser successor = Mockito.mock(Parser.class);
        Parser parser = new TextParser(successor);
        // when
        when(successor.parse(anyString())).thenReturn(paragraph);
        Component actual = parser.parse(TEST_SOURCE);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParseException.class)
    public void testParseShouldThrowParseExceptionWhenSuccessorIsNull() throws ParseException {
        //given
        Parser parser = new TextParser(null);
        // when
        Component actual = parser.parse(TEST_SOURCE);
        //then
    }
}
