package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TextManipulatorImplDataProvider {

    @DataProvider(name = "resolveMathExpressionsSample")
    public static Object[][] getResolveMathExpressionsSample() {
        Component given = getDefault();

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
        return new Object[][]{{given, expected}};
    }

    @DataProvider(name = "restoreTextSample")
    public static Object[][] getRestoreTextSample() {
        Component given = getDefault();
        String expected = "10_13_+_2_* WordTest LongWordTest WordTest 10_13_*_2_+ WordTest LongWordTest" +
                System.lineSeparator() + "LongWordTest WordTest 10_13_*_2_+ WordTest LongWordTest";

        return new Object[][]{{given, expected}};
    }

    @DataProvider(name = "sortParagraphsSample")
    public static Object[][] getSortParagraphsSample() {
        Component given = getDefault();

        Component sentenceFirst = new Composite(Arrays.asList(
                Leaf.mathFrom("10_13_+_2_*"),
                Leaf.wordFrom("WordTest")
        ));
        Component sentenceSecond = new Composite(Arrays.asList(
                Leaf.wordFrom("LongWordTest"),
                Leaf.wordFrom("WordTest"),
                Leaf.mathFrom("10_13_*_2_+")
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
        Component expected = new  Composite(Arrays.asList(
                paragraphSecond,
                paragraphFirst
        ));
        return new Object[][]{{given, expected}};
    }

    @DataProvider(name = "sortWordsInAllSentencesSample")
    public static Object[][] getSortWordsInAllSentencesSample() {
        Component given = getDefault();

        Component sentenceFirst = new Composite(Arrays.asList(
                Leaf.wordFrom("WordTest"),
                Leaf.mathFrom("10_13_+_2_*")
        ));
        Component sentenceSecond = new Composite(Arrays.asList(
                Leaf.wordFrom("WordTest"),
                Leaf.mathFrom("10_13_*_2_+"),
                Leaf.wordFrom("LongWordTest")
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
        Component expected = new  Composite(Arrays.asList(
                paragraphFirst,
                paragraphSecond
        ));
        return new Object[][]{{given, expected}};
    }

    private static Component getDefault() {
        Component sentenceFirst = new Composite(Arrays.asList(
                Leaf.mathFrom("10_13_+_2_*"),
                Leaf.wordFrom("WordTest")
        ));
        Component sentenceSecond = new Composite(Arrays.asList(
                Leaf.wordFrom("LongWordTest"),
                Leaf.wordFrom("WordTest"),
                Leaf.mathFrom("10_13_*_2_+")
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
        return new Composite(Arrays.asList(
                paragraphFirst,
                paragraphSecond
        ));
    }
}
