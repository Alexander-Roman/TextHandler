package com.epam.texthandler.interpreter;

import java.util.Deque;

public class NonTerminalExpression implements Expression {

    private final int value;

    public NonTerminalExpression(int value) {
        this.value = value;
    }

    @Override
    public void interpret(Deque<Integer> context) {
        context.push(value);
    }
}
