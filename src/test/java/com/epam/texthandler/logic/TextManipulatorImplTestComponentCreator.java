package com.epam.texthandler.logic;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Leaf;

import java.util.Arrays;

public class TextManipulatorImplTestComponentCreator {

    private final Component givenSentenceFirst = new Composite(Arrays.asList(
            Leaf.mathFrom("10_13_+_2_*"),
            Leaf.wordFrom("WordTest")
    ));
    private final Component givenSentenceSecond = new Composite(Arrays.asList(
            Leaf.wordFrom("LongWordTest"),
            Leaf.wordFrom("WordTest"),
            Leaf.mathFrom("10_13_*_2_+")
    ));
    private final Component givenSentenceThird = new Composite(Arrays.asList(
            Leaf.wordFrom("WordTest"),
            Leaf.wordFrom("LongWordTest")
    ));
    private final Component givenParagraphFirst = new Composite(Arrays.asList(
            givenSentenceFirst,
            givenSentenceSecond,
            givenSentenceThird
    ));
    private final Component givenParagraphSecond = new Composite(Arrays.asList(
            givenSentenceSecond,
            givenSentenceThird
    ));
    private final Component given = new Composite(Arrays.asList(
            givenParagraphFirst,
            givenParagraphSecond
    ));


    public Component getGiven() {
        return given;
    }

    public Component getResolved() {
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
        return new Composite(Arrays.asList(
                paragraphFirst,
                paragraphSecond
        ));
    }

    public Component getParagraphsSorted() {
        return new Composite(Arrays.asList(
                givenParagraphSecond,
                givenParagraphFirst
        ));
    }

    public Component getWordsBySentencesSorted() {
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
                givenSentenceThird
        ));
        Component paragraphSecond = new Composite(Arrays.asList(
                sentenceSecond,
                givenSentenceThird
        ));
        return new Composite(Arrays.asList(
                paragraphFirst,
                paragraphSecond
        ));
    }
}
