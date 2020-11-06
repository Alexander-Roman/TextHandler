package com.epam.texthandler.parser;

public abstract class AbstractParser implements Parser {

    private Parser successor = null;

    protected Parser getSuccessor() {
        return successor;
    }

    protected void setSuccessor(Parser successor) {
        this.successor = successor;
    }

    protected void validateSuccessor() throws ParseException {
        if (successor == null) {
            throw new ParseException("Successor is not defined!");
        }
    }
}
