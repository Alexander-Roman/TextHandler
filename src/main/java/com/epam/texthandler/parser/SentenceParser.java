package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    private static final String LEXEME = "\\S+";
    private static final Pattern PATTERN = Pattern.compile(LEXEME);

    @Override
    public Component parse(String source) throws ParseException {
        validateSuccessor();

        List<Component> lexemes = new ArrayList<Component>();
        Matcher matcher = PATTERN.matcher(source);
        while (matcher.find()) {
            Parser lexemeParser = getSuccessor();
            String match = matcher.group();
            Component paragraph = lexemeParser.parse(match);
            lexemes.add(paragraph);
        }
        return new Composite(Type.SENTENCE, lexemes);
    }
}
