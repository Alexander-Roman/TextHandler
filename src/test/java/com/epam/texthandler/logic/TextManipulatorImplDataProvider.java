package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TextManipulatorImplDataProvider {

    private static final Component SENTENCE_FIRST = new Composite(Arrays.asList(
            Leaf.mathFrom("10_13_+_2_*"),
            Leaf.wordFrom("WordTest")
    ));
    private static final Component SENTENCE_SECOND = new Composite(Arrays.asList(
            Leaf.wordFrom("LongWordTest"),
            Leaf.wordFrom("WordTest"),
            Leaf.mathFrom("10_13_*_2_+")
    ));
    private static final Component SENTENCE_THIRD = new Composite(Arrays.asList(
            Leaf.wordFrom("WordTest"),
            Leaf.wordFrom("LongWordTest")
    ));
    private static final Component PARAGRAPH_FIRST = new Composite(Arrays.asList(
            SENTENCE_FIRST,
            SENTENCE_SECOND,
            SENTENCE_THIRD
    ));
    private static final Component PARAGRAPH_SECOND = new Composite(Arrays.asList(
            SENTENCE_SECOND,
            SENTENCE_THIRD
    ));
    private static final Component TEXT_GIVEN = new Composite(Arrays.asList(
            PARAGRAPH_FIRST,
            PARAGRAPH_SECOND
    ));


    @DataProvider(name = "resolveMathExpressionsSample")
    public static Object[][] getResolveMathExpressionsSample() {
        Component sentenceFirst = new Composite(Arrays.asList(
                Leaf.wordFrom("46"),
                Leaf.wordFrom("WordTest")
        ));
        Component sentenceSecond = new Composite(Arrays.asList(
                Leaf.wordFrom("LongWordTest"),
                Leaf.wordFrom("WordTest"),
                Leaf.wordFrom("132")
        ));
        Component sentenceThird = new Composite(Arrays.asList(
                Leaf.wordFrom("WordTest"),
                Leaf.wordFrom("LongWordTest")
        ));
        Component paragraphFirst = new Composite(Arrays.asList(
                sentenceFirst,
                sentenceSecond,
                sentenceThird
        ));
        Component paragraphSecond = new Composite(Arrays.asList(
                sentenceSecond,
                sentenceThird
        ));
        Component expected = new Composite(Arrays.asList(
                paragraphFirst,
                paragraphSecond
        ));
        return new Object[][]{{TEXT_GIVEN, expected}};
    }

    @DataProvider(name = "restoreTextSample")
    public static Object[][] getRestoreTextSample() {
        String expected = "10_13_+_2_* WordTest LongWordTest WordTest 10_13_*_2_+ WordTest LongWordTest" +
                System.lineSeparator() + "LongWordTest WordTest 10_13_*_2_+ WordTest LongWordTest";

        return new Object[][]{{TEXT_GIVEN, expected}};
    }

    @DataProvider(name = "sortParagraphsSample")
    public static Object[][] getSortParagraphsSample() {
        Component expected = new Composite(Arrays.asList(
                PARAGRAPH_SECOND,
                PARAGRAPH_FIRST
        ));
        return new Object[][]{{TEXT_GIVEN, expected}};
    }

    @DataProvider(name = "sortWordsInAllSentencesSample")
    public static Object[][] getSortWordsInAllSentencesSample() {
        Component sentenceFirst = new Composite(Arrays.asList(
                Leaf.wordFrom("WordTest"),
                Leaf.mathFrom("10_13_+_2_*")
        ));
        Component sentenceSecond = new Composite(Arrays.asList(
                Leaf.wordFrom("WordTest"),
                Leaf.mathFrom("10_13_*_2_+"),
                Leaf.wordFrom("LongWordTest")
        ));
        Component paragraphFirst = new Composite(Arrays.asList(
                sentenceFirst,
                sentenceSecond,
                SENTENCE_THIRD
        ));
        Component paragraphSecond = new Composite(Arrays.asList(
                sentenceSecond,
                SENTENCE_THIRD
        ));
        Component expected = new Composite(Arrays.asList(
                paragraphFirst,
                paragraphSecond
        ));
        return new Object[][]{{TEXT_GIVEN, expected}};
    }
}
