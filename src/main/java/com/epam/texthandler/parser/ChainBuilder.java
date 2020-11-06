package com.epam.texthandler.parser;

public class ChainBuilder {

    public Parser build() {
        LexemeParser lexemeParser = new LexemeParser();

        SentenceParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        TextParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        return textParser;
    }
}
