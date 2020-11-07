package com.epam.texthandler.parser;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser successor() throws ParseException {
        if (successor == null) {
            throw new ParseException("Successor is not defined!");
        }
        return successor;
    }
}
