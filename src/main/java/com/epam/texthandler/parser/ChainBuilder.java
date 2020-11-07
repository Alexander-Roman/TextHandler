package com.epam.texthandler.parser;

public class ChainBuilder {

    public Parser build() {
        LexemeParser lexemeParser = new LexemeParser(null);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextParser(paragraphParser);
    }
}
