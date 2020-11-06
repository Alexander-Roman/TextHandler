package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Leaf;
import com.epam.texthandler.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {

    private static final String MATH = "([+0-9\\-*/]+)\\.*";
    private static final int MATH_GROUP = 1;
    private static final Pattern PATTERN = Pattern.compile(MATH);

    @Override
    public Component parse(String source) {
        Matcher matcher = PATTERN.matcher(source);
        Component component;
        if (matcher.find()) {
            String value = matcher.group(MATH_GROUP);
            component = new Leaf(Type.MATH, value);
        } else {
            component = new Leaf(Type.WORD, source);
        }
        return component;
    }
}
