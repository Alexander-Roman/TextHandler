package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {

    private static final String SENTENCE = "\\s?(.+?[.!?])";
    private static final int SENTENCE_GROUP = 1;
    private static final Pattern PATTERN = Pattern.compile(SENTENCE);

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String source) throws ParseException {
        List<Component> sentences = new ArrayList<Component>();
        Matcher matcher = PATTERN.matcher(source);
        Parser sentenceParser = successor();
        while (matcher.find()) {
            String match = matcher.group(SENTENCE_GROUP);
            Component paragraph = sentenceParser.parse(match);
            sentences.add(paragraph);
        }
        return new Composite(sentences);
    }
}
