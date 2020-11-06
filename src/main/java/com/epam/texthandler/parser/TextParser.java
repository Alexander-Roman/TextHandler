package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Composite;
import com.epam.texthandler.composite.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser {

    private static final String PARAGRAPH = ".+";
    private static final Pattern PATTERN = Pattern.compile(PARAGRAPH);

    @Override
    public Component parse(String source) throws ParseException {
        validateSuccessor();

        List<Component> paragraphs = new ArrayList<Component>();
        Matcher matcher = PATTERN.matcher(source);
        Parser paragraphParser = getSuccessor();
        while (matcher.find()) {
            String match = matcher.group();
            Component paragraph = paragraphParser.parse(match);
            paragraphs.add(paragraph);
        }
        return new Composite(Type.TEXT, paragraphs);
    }
}
