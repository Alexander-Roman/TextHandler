package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;
import com.epam.texthandler.composite.Leaf;
import com.epam.texthandler.composite.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {

    private static final String MATH = "[0-9_+*]+";
    private static final Pattern PATTERN = Pattern.compile(MATH);

    @Override
    public Component parse(String source) {
        Matcher matcher = PATTERN.matcher(source);
        Component component;
        if (matcher.matches()) {
            component = new Leaf(Type.MATH, source);
        } else {
            component = new Leaf(Type.WORD, source);
        }
        return component;
    }
}
