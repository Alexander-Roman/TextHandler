package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextManipulatorImplTest {

    private final TextManipulator manipulator = new TextManipulatorImpl();

    @Test(dataProvider = "resolveMathExpressionsSample", dataProviderClass = TextManipulatorImplDataProvider.class)
    public void testResolveMathExpressionsShouldReturnComponentWithCalculatedMathValues(Component given, Component expected) {
        //given
        //when
        Component actual = manipulator.resolveMathExpressions(given);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "restoreTextSample", dataProviderClass = TextManipulatorImplDataProvider.class)
    public void testRestoreTextShouldReturnCorrectStringRepresentation(Component given, String expected) {
        //given
        //when
        String actual = manipulator.restoreText(given);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sortParagraphsSample", dataProviderClass = TextManipulatorImplDataProvider.class)
    public void testSortParagraphsShouldReturnComponentWithParagraphsSortedByNumberOfSentences(Component given, Component expected) {
        //given
        //when
        Component actual = manipulator.sortParagraphs(given);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sortWordsInAllSentencesSample", dataProviderClass = TextManipulatorImplDataProvider.class)
    public void testSortParagraphsShouldReturnComponentWithWordsSortedByLengthInSentences(Component given, Component expected) {
        //given
        //when
        Component actual = manipulator.sortWordsInAllSentences(given);
        //then
        Assert.assertEquals(actual, expected);
    }
}
