package com.epam.texthandler.parser;

import com.epam.texthandler.composite.Component;

public interface Parser {

    Component parse(String source) throws ParseException;
}
