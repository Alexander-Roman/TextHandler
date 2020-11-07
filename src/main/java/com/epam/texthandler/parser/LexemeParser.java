package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Leaf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {

    private static final String MATH = "[0-9_+*]+";
    private static final Pattern PATTERN = Pattern.compile(MATH);

    public LexemeParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String source) {
        Matcher matcher = PATTERN.matcher(source);
        Component component;
        if (matcher.matches()) {
            component = Leaf.mathFrom(source);
        } else {
            component = Leaf.wordFrom(source);
        }
        return component;
    }
}
