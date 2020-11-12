package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.interpreter.Interpreter;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class TextManipulatorImplTest {

    private final Interpreter interpreter = Mockito.mock(Interpreter.class);
    private final TextManipulator manipulator = new TextManipulatorImpl(interpreter);
    private Component given;
    private Component resolveMathExpected;
    private Component sortParagraphsExpected;
    private Component sortWordsInAllSentencesExpected;

    @BeforeClass
    public void setUp() {
        TextManipulatorImplTestComponentCreator creator = new TextManipulatorImplTestComponentCreator();
        given = creator.getGiven();
        resolveMathExpected = creator.getMathResolved();
        sortParagraphsExpected = creator.getParagraphsSorted();
        sortWordsInAllSentencesExpected = creator.getWordsBySentencesSorted();
    }

    @Test
    public void testResolveMathExpressionsShouldReturnComponentWithCalculatedMathValues() {
        //given
        //when
        when(interpreter.calculate(anyString())).thenReturn(46).thenReturn(132);
        Component actual = manipulator.resolveMathExpressions(given);
        //then
        Assert.assertEquals(actual, resolveMathExpected);
    }

    @Test
    public void testRestoreTextShouldReturnCorrectStringRepresentation() {
        //given
        //when
        String actual = manipulator.restoreText(given);
        //then
        String expected = "10_13_+_2_* WordTest LongWordTest WordTest 10_13_*_2_+ WordTest LongWordTest" +
                System.lineSeparator() + "LongWordTest WordTest 10_13_*_2_+ WordTest LongWordTest";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortParagraphsShouldReturnComponentWithParagraphsSortedByNumberOfSentences() {
        //given
        //when
        Component actual = manipulator.sortParagraphs(given);
        //then
        Assert.assertEquals(actual, sortParagraphsExpected);
    }

    @Test
    public void testSortParagraphsShouldReturnComponentWithWordsSortedByLengthInSentences() {
        //given
        //when
        Component actual = manipulator.sortWordsInAllSentences(given);
        //then
        Assert.assertEquals(actual, sortWordsInAllSentencesExpected);
    }
}
